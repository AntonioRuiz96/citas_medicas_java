package metaenlace.citas_medicas.controllerImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import metaenlace.citas_medicas.controller.CitaController;
import metaenlace.citas_medicas.entitiesDTO.CitaDTO;
import metaenlace.citas_medicas.service.CitaService;

@RestController
public class CitaControllerImpl implements CitaController{

	private final CitaService citaService;

    @Autowired
    public CitaControllerImpl(CitaService citaService) {
    	this.citaService = citaService;
    }
    
	@Override
	@RequestMapping(value = "/citas", method = RequestMethod.GET, produces = "application/json")
	public List<CitaDTO> getCitas() {
		return citaService.findAllCitas();
	}

	@Override
	@RequestMapping(value = "/citas/{id}", method = RequestMethod.GET, produces = "application/json")	
	public Optional<CitaDTO> getCitaById(@PathVariable Integer id) {
		return citaService.findCitaById(id);
	}

	@Override
	@RequestMapping(value = "/citas/add", method = RequestMethod.POST, produces = "application/json")
	public CitaDTO addCita(@RequestBody CitaDTO nuevaCita) {
		return citaService.saveCita(nuevaCita);
	}

	@Override
	@RequestMapping(value = "/citas/delete/{id}", method = RequestMethod.GET, produces = "application/json")
	public String deleteCita(@PathVariable Integer id) {
		return citaService.deleteCita(id);
	}

}