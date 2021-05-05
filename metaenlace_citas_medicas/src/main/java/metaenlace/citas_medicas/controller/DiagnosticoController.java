package metaenlace.citas_medicas.controller;

import java.util.List;
import java.util.Optional;

import metaenlace.citas_medicas.entitiesDTO.DiagnosticoDTO;

public interface DiagnosticoController {

	public List<DiagnosticoDTO> getDiagnosticos();

	public Optional<DiagnosticoDTO> getDiagnosticoById(Integer id);

	public DiagnosticoDTO addDiagnostico(DiagnosticoDTO diagnostico);

	public String deleteDiagnostico(Integer id);
}
