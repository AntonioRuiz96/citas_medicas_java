package metaenlace.citas_medicas.controllerImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import metaenlace.citas_medicas.controller.PacienteController;
import metaenlace.citas_medicas.entitiesDTO.PacienteDTO;
import metaenlace.citas_medicas.service.PacienteService;

@RestController
public class PacienteControllerImpl implements PacienteController{

	private final PacienteService pacienteService;

    @Autowired
    public PacienteControllerImpl(PacienteService pacienteService) {
    	this.pacienteService = pacienteService;
    }
    
	@Override
	@RequestMapping(value = "/pacientes", method = RequestMethod.GET, produces = "application/json")
	public List<PacienteDTO> getPacientes() {
		return pacienteService.findAllPacientes();
	}

	@Override
	@RequestMapping(value = "/pacientes/{id}", method = RequestMethod.GET, produces = "application/json")	
	public Optional<PacienteDTO> getPacienteById(@PathVariable Integer id) {
		return pacienteService.findPacienteById(id);
	}

	@Override
	@RequestMapping(value = "/pacientes/add", method = RequestMethod.POST, produces = "application/json")
	public PacienteDTO addPaciente(@RequestBody PacienteDTO nuevoPaciente) {
		return pacienteService.savePaciente(nuevoPaciente);
	}

	@Override
	@RequestMapping(value = "/pacientes/delete/{id}", method = RequestMethod.GET, produces = "application/json")
	public String deletePaciente(@PathVariable Integer id) {
		return pacienteService.deletePaciente(id);
	}

}
