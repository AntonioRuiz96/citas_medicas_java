package metaenlace.citas_medicas.controller;

import java.util.List;
import java.util.Optional;

import metaenlace.citas_medicas.entitiesDTO.PacienteDTO;

public interface PacienteController {

	public List<PacienteDTO> getPacientes();

	public Optional<PacienteDTO> getPacienteById(Integer id);

	public PacienteDTO addPaciente(PacienteDTO paciente);

	public String deletePaciente(Integer id);
}
