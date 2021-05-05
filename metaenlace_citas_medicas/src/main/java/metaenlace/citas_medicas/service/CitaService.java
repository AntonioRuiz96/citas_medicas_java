package metaenlace.citas_medicas.service;

import java.util.List;
import java.util.Optional;

import metaenlace.citas_medicas.entitiesDTO.CitaDTO;

public interface CitaService {
	
	public List<CitaDTO> findAllCitas();

	public Optional<CitaDTO> findCitaById(Integer id);

	public CitaDTO saveCita(CitaDTO nuevaCita);

	public String deleteCita(Integer id);
}
