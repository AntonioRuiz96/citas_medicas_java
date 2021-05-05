package metaenlace.citas_medicas.controller;

import java.util.List;
import java.util.Optional;

import metaenlace.citas_medicas.entitiesDTO.CitaDTO;

public interface CitaController {

	public List<CitaDTO> getCitas();

	public Optional<CitaDTO> getCitaById(Integer id);

	public CitaDTO addCita(CitaDTO cita);

	public String deleteCita(Integer id);
}
