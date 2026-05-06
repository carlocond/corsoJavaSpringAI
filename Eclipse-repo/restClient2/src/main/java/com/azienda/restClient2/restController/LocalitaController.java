package com.azienda.restClient2.restController;

import java.util.ArrayList;
import java.util.List;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

import org.springframework.web.bind.annotation.RestController;
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

import com.azienda.restClient2.dto.LocalitaDto;

@RestController
@RequestMapping(path="/api/v1",produces = "application/json")
@CrossOrigin(origins = {"*"})
@Validated
public class LocalitaController {

private List<LocalitaDto> listaLocalita;
	
	public LocalitaController() {
		listaLocalita=new ArrayList<LocalitaDto>();
		listaLocalita.add(new LocalitaDto(1,"Roma",23f));
		listaLocalita.add(new LocalitaDto(2,"Milano",20.2f));
		listaLocalita.add(new LocalitaDto(3,"Napoli",25.6f));
		listaLocalita.add(new LocalitaDto(4,"Catania",28.1f));
		System.out.println("RestController creato");
	}
	
	@GetMapping("/getAllLocalita")
	@ResponseStatus(HttpStatus.OK)
	public List<LocalitaDto> getAllLocalita(){
		return listaLocalita;
	}
	
	@GetMapping("/localita/{id}")
	public ResponseEntity<LocalitaDto> getById(
			@Min(value=0,message = "L'id deve essere maggiore di zero")
			@PathVariable("id")
			Integer id
	){
		try {
			LocalitaDto l = listaLocalita.get(id);
			if(l != null) {
				return new ResponseEntity<LocalitaDto>(l, HttpStatus.OK);
			}else {
				return new ResponseEntity<LocalitaDto>(HttpStatus.NOT_FOUND);
			}
		}catch(IndexOutOfBoundsException e) {
			e.printStackTrace();
			return new ResponseEntity<LocalitaDto>(HttpStatus.BAD_REQUEST);
		}
		catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<LocalitaDto>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/localita")
	public ResponseEntity<LocalitaDto> getByNome(@NotBlank(message="Il nome è obbligatorio") @RequestParam String nome){
		try {
			List<LocalitaDto> found=listaLocalita.stream().filter((loc)->{
				return loc.getNome().equals(nome)?true:false;
			}).toList();
			if(found.size()>0) {
				return new ResponseEntity<LocalitaDto>(found.getFirst(),HttpStatus.OK);
			}else {
				return new ResponseEntity<LocalitaDto>(HttpStatus.NOT_FOUND);
			}
		}catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<LocalitaDto>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/maxTemperatura")
	@ResponseStatus(HttpStatus.OK)
	public List<LocalitaDto> maxTemp(
			@Min(value = -40l,message = "La temperatura deve essere maggiore di -40")
			@Max(value = 55l,message = "La temperatura deve essere minore di 55")
			@RequestParam
			Float temp
	){
		
		return listaLocalita.stream().filter((loc)->{
			if(loc.getTemperatura() <= temp) {
				return true;
			}
			return false;
		}).toList();
	}
	
	@GetMapping("/minTemperatura")
	@ResponseStatus(HttpStatus.OK)
	public List<LocalitaDto> minTemp(
			@Min(value = -40l,message = "La temperatura deve essere maggiore di -40")
			@Max(value = 55l,message = "La temperatura deve essere minore di 55")
			@RequestParam
			Float temp
	){
		
		return listaLocalita.stream().filter((loc)->{
			if(loc.getTemperatura() >= temp) {
				return true;
			}
			return false;
		}).toList();
	}
	
	@PostMapping("/nuovaLocalita")
	@ResponseStatus(HttpStatus.CREATED)
	public LocalitaDto nuovaLocalita(@Valid @RequestBody LocalitaDto l) {
		
		if(listaLocalita.add(l)) return listaLocalita.get(listaLocalita.indexOf(l));
		
		return null;
	}
	
	@PutMapping(path="/aggiornamentoCompleto/{id}",consumes="application/json")
	public ResponseEntity<String> aggiornamentoCompleto(
			@Positive(message = "L'id deve essere positivo")
			@PathVariable("id") 
			Integer id,
			@Valid 
			@RequestBody 
			LocalitaDto l
	) {
		try {
			LocalitaDto trovata=listaLocalita.get(id);
			
			if(trovata!=null) {
				trovata.setNome(l.getNome());
				trovata.setTemperatura(l.getTemperatura());
				return new ResponseEntity<String>("Località aggiornata",HttpStatus.OK);
			}
			else {
				return new ResponseEntity<String>("Id non trovato",HttpStatus.NOT_FOUND);
			}
		}catch(IndexOutOfBoundsException e) {
			e.printStackTrace();
			return new ResponseEntity<String>("Hai inserito un id sbagliato",HttpStatus.BAD_REQUEST);
		}catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PatchMapping(path="/aggiornamentoParziale/{id}",consumes="application/json")
	public ResponseEntity<String> aggiornamentoParziale(
				@Positive(message = "L'id deve essere positivo")
				@PathVariable("id") 
				Integer id,
				@RequestBody
				@NotBlank(message = "Il nome è obbligatorio")
				String nome
			) {
		try {
			LocalitaDto trovata=listaLocalita.get(id);
			if(trovata!=null) {
				trovata.setNome("Nome cambiato");
				return new ResponseEntity<String>("Nome della Località aggiornato",HttpStatus.OK);
			}else {
				return new ResponseEntity<String>("Nome non trovato nella lista",HttpStatus.NOT_FOUND);
			}
		}catch(IndexOutOfBoundsException e) {
			e.printStackTrace();
			return new ResponseEntity<String>("Hai inserito un id errato",HttpStatus.BAD_REQUEST);
		}catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/eliminaLocalita/{id}")
	public ResponseEntity<LocalitaDto> eliminaLocalita(
			@Positive(message = "L'id deve essere positivo")
			@PathVariable("id")
			Integer id
	){
		try {
			LocalitaDto trovata=listaLocalita.get(listaLocalita.indexOf(listaLocalita.stream().filter((loc)->{
				if(loc.getId().equals(id))
					return true;
				return false;
			}).toList().getFirst()));
			if(trovata!=null) {
				listaLocalita.remove(trovata);
				return new ResponseEntity<LocalitaDto>(trovata,HttpStatus.NO_CONTENT);
			}else {
				return new ResponseEntity<LocalitaDto>(HttpStatus.NOT_FOUND);
			}
		}catch(IndexOutOfBoundsException e) {
			e.printStackTrace();
			return new ResponseEntity<LocalitaDto>(HttpStatus.BAD_REQUEST);
		}
		catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<LocalitaDto>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/eliminaMinoreDi/{maxTemp}")
	public ResponseEntity<List<LocalitaDto>> eliminaLocalitaMinoreDi(
			@Min(value = -40l,message = "La temperatura deve essere maggiore di -40")
			@Max(value = 55l,message = "La temperatura deve essere minore di 55")
			@PathVariable("maxTemp")
			Float maxTemp
	){
		try {
			List<LocalitaDto> trovate=listaLocalita.stream().filter((loc)->{
				if(loc.getTemperatura()<maxTemp) {
					return true;
				}
				return false;
			}).toList();
			if(trovate.size()>0) {
				trovate.forEach((loc)->{
					listaLocalita.remove(loc);
				});
				return new ResponseEntity<List<LocalitaDto>>(trovate,HttpStatus.NO_CONTENT);
			}else {
				return new ResponseEntity<List<LocalitaDto>>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<List<LocalitaDto>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/eliminaMaggioreDi/{minTemp}")
	public ResponseEntity<List<LocalitaDto>> eliminaLocalitaMaggioreDi(
			@Min(value = -40l,message = "La temperatura deve essere maggiore di -40")
			@Max(value = 55l,message = "La temperatura deve essere minore di 55")
			@PathVariable("minTemp")
			Float minTemp
	){
		try {
			List<LocalitaDto> trovate=listaLocalita.stream().filter((loc)->{
				if(loc.getTemperatura()>minTemp) {
					return true;
				}
				return false;
			}).toList();
			if(trovate.size()>0) {
				trovate.forEach((loc)->{
					listaLocalita.remove(loc);
				});
				return new ResponseEntity<List<LocalitaDto>>(trovate,HttpStatus.NO_CONTENT);
			}else {
				return new ResponseEntity<List<LocalitaDto>>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<List<LocalitaDto>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
