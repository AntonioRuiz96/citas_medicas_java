package metaenlace.citas_medicas.controllerImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import metaenlace.citas_medicas.controller.DiagnosticoController;
import metaenlace.citas_medicas.entitiesDTO.DiagnosticoDTO;
import metaenlace.citas_medicas.service.DiagnosticoService;

@RestController
public class DiagnosticoControllerImpl implements DiagnosticoController{
	
	private final DiagnosticoService diagnosticoService;

    @Autowired
    public DiagnosticoControllerImpl(DiagnosticoService diagnosticoService) {
    	this.diagnosticoService = diagnosticoService;
    }
    
	@Override
	@RequestMapping(value = "/diagnosticos", method = RequestMethod.GET, produces = "application/json")
	public List<DiagnosticoDTO> getDiagnosticos() {
		return diagnosticoService.findAllDiagnosticos();
	}

	@Override
	@RequestMapping(value = "/diagnosticos/{id}", method = RequestMethod.GET, produces = "application/json")	
	public Optional<DiagnosticoDTO> getDiagnosticoById(@PathVariable Integer id) {
		return diagnosticoService.findDiagnosticoById(id);
	}

	@Override
	@RequestMapping(value = "/diagnosticos/add", method = RequestMethod.POST, produces = "application/json")
	public DiagnosticoDTO addDiagnostico(@RequestBody DiagnosticoDTO nuevoDiagnostico) {
		return diagnosticoService.saveDiagnostico(nuevoDiagnostico);
	}

	@Override
	@RequestMapping(value = "/diagnosticos/delete/{id}", method = RequestMethod.GET, produces = "application/json")
	public String deleteDiagnostico(@PathVariable Integer id) {
		return diagnosticoService.deleteDiagnostico(id);
	}

}
