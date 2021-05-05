package metaenlace.citas_medicas.service;

import java.util.List;
import java.util.Optional;

import metaenlace.citas_medicas.entitiesDTO.MedicoDTO;

public interface MedicoService {
	public List<MedicoDTO> findAllMedicos();

	public Optional<MedicoDTO> findMedicoById(Integer id);

	public MedicoDTO saveMedico(MedicoDTO nuevoMedico);

	public String deleteMedico(Integer id);
}
