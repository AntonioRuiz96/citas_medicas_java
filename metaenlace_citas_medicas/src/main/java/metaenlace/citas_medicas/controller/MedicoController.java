package metaenlace.citas_medicas.controller;

import java.util.List;
import java.util.Optional;

import metaenlace.citas_medicas.entitiesDTO.MedicoDTO;

public interface MedicoController {

	public List<MedicoDTO> getMedicos();

	public Optional<MedicoDTO> getMedicoById(Integer id);

	public MedicoDTO addMedico(MedicoDTO medico);

	public String deleteMedico(Integer id);
	
}
