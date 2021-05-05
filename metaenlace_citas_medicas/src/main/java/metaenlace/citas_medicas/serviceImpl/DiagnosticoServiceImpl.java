package metaenlace.citas_medicas.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import metaenlace.citas_medicas.entities.Cita;
import metaenlace.citas_medicas.entities.Diagnostico;
import metaenlace.citas_medicas.entitiesDTO.DiagnosticoDTO;
import metaenlace.citas_medicas.repositories.CitaRepository;
import metaenlace.citas_medicas.repositories.DiagnosticoRepository;
import metaenlace.citas_medicas.service.DiagnosticoService;

@Service
public class DiagnosticoServiceImpl implements DiagnosticoService {
	
	private final DiagnosticoRepository diagnosticoRepository;
	private final CitaRepository citaRepository;
	private ModelMapper mapper = new ModelMapper();

    @Autowired
    public DiagnosticoServiceImpl(DiagnosticoRepository diagnosticoRepository, CitaRepository citaRepository) {
    	this.diagnosticoRepository = diagnosticoRepository;
    	this.citaRepository = citaRepository;
    }

	@Override
	public List<DiagnosticoDTO> findAllDiagnosticos() {
		List<Diagnostico> diagnosticos = diagnosticoRepository.findAll();
		List<DiagnosticoDTO> diagnosticosDTO = new ArrayList<DiagnosticoDTO>();
		for(Diagnostico d: diagnosticos) {
			DiagnosticoDTO diag = mapper.map(d, DiagnosticoDTO.class);//Listas quedan como atributos null

			diagnosticosDTO.add(diag);
		}
		return diagnosticosDTO;	}

	@Override
	public Optional<DiagnosticoDTO> findDiagnosticoById(Integer id) {
		Optional<DiagnosticoDTO> diagnosticoDTO =Optional.of(mapper.map(diagnosticoRepository.findById(id).get(), DiagnosticoDTO.class));
		return diagnosticoDTO;
	}

	@Override
	public DiagnosticoDTO saveDiagnostico(DiagnosticoDTO nuevoDiagnostico) {
		if (nuevoDiagnostico != null) {
			Diagnostico diagnostico = new Diagnostico(0, nuevoDiagnostico.getDiagnosticoValoracionEspecialista(),
					nuevoDiagnostico.getDiagnosticoEnfermedad(), null);
			if(nuevoDiagnostico.getDiagnosticoCitaCitaID() != null) {
				Optional<Cita> citaExists = citaRepository.findById(nuevoDiagnostico.getDiagnosticoCitaCitaID());
				if(citaExists.isPresent()) {
					diagnostico.setCita(citaExists.get());
					
					diagnostico.setDiagnosticoID(diagnosticoRepository.save(diagnostico).getDiagnosticoID());
					
					citaExists.get().setDiagnostico(diagnostico);
					citaRepository.save(citaExists.get());

					return nuevoDiagnostico;
				}
			}
			diagnosticoRepository.save(diagnostico);
			return nuevoDiagnostico;
		}
		return null;
	}

	@Override
	public String deleteDiagnostico(Integer id) {
		if (diagnosticoRepository.findById(id).isPresent()) {
			diagnosticoRepository.deleteById(id);
			return "Diagnostico eliminado correctamente.";
		}
		return "Error! El Diagnostico no existe";
	}

}
