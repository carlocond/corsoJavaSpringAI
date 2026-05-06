package com.azienda.restClient2.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.azienda.restClient2.dto.LocalitaAiDto;
import com.azienda.restClient2.model.Localita;
import com.azienda.restClient2.repository.LocalitaRepository;

@Service
@Transactional
public class LocalitaService {

	@Autowired
	private LocalitaRepository localitaRepository;
	
	public Localita create(Localita l) {
		return localitaRepository.save(new Localita(l.getNome(),l.getTemperatura()));
	}
	
	public Localita readById(Integer id) {
		return localitaRepository.findById(id).orElse(null);
	}
	
	public Localita readByNome(String nome) {
		return localitaRepository.findByNome(nome).getFirst();
	}
	
	public List<Localita> localitaConTemperatureMinoriDi(Float maxTemp){
		return localitaRepository.findByTemperaturaLessThanEqual(maxTemp);
	}
	
	public List<Localita> localitaConTemperatureMaggioriDi(Float minTemp){
		return localitaRepository.findByTemperaturaGreaterThanEqual(minTemp);
	}
	
	public List<Localita> readAll(){
		return localitaRepository.findAll();
	}
	
	public Localita updateById(Integer id,Localita l) {
		Localita trovata=localitaRepository.findById(id).orElseThrow();
		
		trovata.setNome(l.getNome());
		trovata.setTemperatura(l.getTemperatura());
		
		return trovata;
	}
	
	public void updateByIdNewTemperatura(Integer id,Float nuovaTemp) {
		Localita trovata=localitaRepository.findById(id).orElseThrow();
		
		if (trovata!=null) {
			trovata.setTemperatura(nuovaTemp);
			localitaRepository.save(trovata);
		}
	}
	
	public List<LocalitaAiDto> creaDaLista(List<LocalitaAiDto> dto){
		dto.forEach((l)->localitaRepository.save(new Localita(l.localita(), l.temperatura())));
		
		List<LocalitaAiDto> result=new ArrayList<LocalitaAiDto>();
		
		for(LocalitaAiDto l: dto) {
			if(localitaRepository.existsByNome(l.localita())) {
				Localita loc=localitaRepository.selectByNome(l.localita());
				result.add(new LocalitaAiDto(loc.getId(), loc.getNome(), loc.getTemperatura()));
			}
		}
		
		return result;
	}
	
	public List<Localita> ricercaByKeyword(String kw){
		return localitaRepository.findByNomeContaining(kw);
	}
	
	public void deleteById(Integer id) {
		localitaRepository.deleteById(id);
	}
	
}
