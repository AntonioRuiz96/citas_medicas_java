package metaenlace.citas_medicas.service;

import java.util.List;
import java.util.Optional;

import metaenlace.citas_medicas.entitiesDTO.DiagnosticoDTO;


public interface DiagnosticoService {
	public List<DiagnosticoDTO> findAllDiagnosticos();

	public Optional<DiagnosticoDTO> findDiagnosticoById(Integer id);

	public DiagnosticoDTO saveDiagnostico(DiagnosticoDTO nuevoDiagnostico);

	public String deleteDiagnostico(Integer id);
}
