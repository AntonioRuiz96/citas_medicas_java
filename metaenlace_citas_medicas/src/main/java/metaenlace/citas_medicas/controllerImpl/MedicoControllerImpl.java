package metaenlace.citas_medicas.controllerImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import metaenlace.citas_medicas.controller.MedicoController;
import metaenlace.citas_medicas.entitiesDTO.MedicoDTO;
import metaenlace.citas_medicas.service.MedicoService;

@RestController
public class MedicoControllerImpl implements MedicoController{

	private final MedicoService medicoService;


    @Autowired
    public MedicoControllerImpl(MedicoService medicoService) {
    	this.medicoService = medicoService;
    }
    
	@Override
	@RequestMapping(value = "/medicos", method = RequestMethod.GET, produces = "application/json")
	public List<MedicoDTO> getMedicos() {
		return medicoService.findAllMedicos();
	}

	@Override
	@RequestMapping(value = "/medicos/{id}", method = RequestMethod.GET, produces = "application/json")	
	public Optional<MedicoDTO> getMedicoById(@PathVariable Integer id) {
		return medicoService.findMedicoById(id);
	}

	@Override
	@RequestMapping(value = "/medicos/add", method = RequestMethod.POST, produces = "application/json")
	public MedicoDTO addMedico(@RequestBody MedicoDTO nuevoMedico) {
		return medicoService.saveMedico(nuevoMedico);
	}

	@Override
	@RequestMapping(value = "/medicos/delete/{id}", method = RequestMethod.GET, produces = "application/json")
	public String deleteMedico(@PathVariable Integer id) {
		return medicoService.deleteMedico(id);
	}

}
