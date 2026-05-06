package com.azienda.restClient2.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.azienda.restClient2.model.Localita;
import com.azienda.restClient2.service.LocalitaService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@RestController
@RequestMapping("/api/v2")
@CrossOrigin("*")
@Validated
public class LocalitaRestController {

	@Autowired
	private LocalitaService service;
	
	
	@PostMapping("/aggiungiLocalita")
	@ResponseStatus(HttpStatus.CREATED)
	public Localita aggiungiLocalita(
			@Valid
			@RequestBody 
			Localita l
	) {
		
		return service.create(l);
	}
	
	@GetMapping("/getAll")
	@ResponseStatus(HttpStatus.OK)
	public List<Localita> getAll(){
		return service.readAll();
	}
	
	@GetMapping("/getById/{id}")
	public ResponseEntity<Localita> getById(
			@NotNull(message = "L'id è obbligatorio")
			@Min(value=0,message="L'id deve essere maggiore o uguale a zero")
			@PathVariable
			Integer id
	){
		try {
			Localita l = service.readById(id);
			
			if(l != null) {
				return new ResponseEntity<Localita>(l, HttpStatus.OK);
			}
			else {
				return new ResponseEntity<Localita>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Localita>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/updateById/{id}")
	public ResponseEntity<String> updateById(
			@NotNull(message = "L'id è obbligatorio")
			@Min(value=0,message = "L'id deve essere >=0")
			@PathVariable
			Integer id,
			@Valid
			@RequestBody
			Localita l
	){
		try {
			Localita loc=service.readById(id);
			
			if(loc != null) {
				service.updateById(id, loc);
				return new ResponseEntity<String>("La località è stata aggiornata",HttpStatus.OK);
			}
			else {
				return new ResponseEntity<String>("La localita non id "+id+" non è stata trovata",HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PatchMapping("/updateTemperaturaById/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void updateTemperaturaById(
			@NotNull(message = "L'id è obbligatorio")
			@Min(value=1,message = "L'id deve essere >=0")
			@PathVariable
			Integer id,
			@RequestBody
			@Min(value=-40,message = "La temperatura deve essere maggiore di -40")
			@Max(value=55,message="La temperatura deve essere minore di 55")
			Float temp
	) {
		service.updateByIdNewTemperatura(id, temp);
	}
	
	@DeleteMapping("/deleteById")
	public ResponseEntity<String> deleteById(
			@Min(value=0,message = "L'id deve essere >=0")
			@NotNull(message = "L'id è obbligatorio")
			Integer id
	){
		try {
			Localita temp = service.readById(id);
			
			if(temp != null) {
				service.deleteById(id);
				return new ResponseEntity<String>("La località è stata eliminata",HttpStatus.NO_CONTENT);
			}
			else {
				return new ResponseEntity<String>("La località con l'id "+id+" non è stata trovata",HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/maxTemperatura")
	@ResponseStatus(HttpStatus.OK)
	public List<Localita> localitaConTempMinoriDi(
			@NotNull(message = "La temperatura è obbligatoria")
			@Min(value=-40,message = "La temperatura deve essere maggiore di -40")
			@Max(value=55,message = "La temperatura deve essere minore di 55")
			@RequestParam
			Float maxTemp
	){
		return service.localitaConTemperatureMinoriDi(maxTemp);
	}
	
	@GetMapping("/minTemperatura")
	@ResponseStatus(HttpStatus.OK)
	public List<Localita> localitaConTempMaggioriDi(
			@NotNull(message = "La temperatura è obbligatoria")
			@Min(value=-40,message = "La temperatura deve essere maggiore di -40")
			@Max(value=55,message = "La temperatura deve essere minore di 55")
			@RequestParam
			Float minTemp
	){
		return service.localitaConTemperatureMaggioriDi(minTemp);
	}
	
	@DeleteMapping("/deleteMaxTemperatura/{maxTemperatura}")
	public ResponseEntity<Boolean> deleteMaxTemperatura(
			@NotNull(message = "La temperatura è obbligatoria")
			@Min(value=-40,message = "La temperatura deve essere maggiore di -40")
			@Max(value=55,message = "La temperatura deve essere minore di 55")
			@PathVariable
			Float maxTemp
	){
		try {
			List<Localita> trovate=service.localitaConTemperatureMinoriDi(maxTemp);
			
			if(!trovate.isEmpty()) {
				trovate.forEach((loc)->{
					service.deleteById(loc.getId());
				});
				return new ResponseEntity<Boolean>(true,HttpStatus.NO_CONTENT);
			}
			else {
				return new ResponseEntity<Boolean>(false,HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Boolean>(false,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/deleteMinTemperatura/{minTemperatura}")
	public ResponseEntity<Boolean> deleteMinTemperatura(
			@NotNull(message = "La temperatura è obbligatoria")
			@Min(value=-40,message = "La temperatura deve essere maggiore di -40")
			@Max(value=55,message = "La temperatura deve essere minore di 55")
			@PathVariable
			Float minTemp
	){
		try {
			List<Localita> trovate=service.localitaConTemperatureMaggioriDi(minTemp);
			
			if(!trovate.isEmpty()) {
				trovate.forEach((loc)->{
					service.deleteById(loc.getId());
				});
				return new ResponseEntity<Boolean>(true,HttpStatus.NO_CONTENT);
			}
			else {
				return new ResponseEntity<Boolean>(false,HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Boolean>(false,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/ricercaLocalita")
	@ResponseStatus(HttpStatus.OK)
	public List<Localita> ricercaLocalita(@RequestParam(name = "keyword") String kw){
		return service.ricercaByKeyword(kw);
	}
	
}
