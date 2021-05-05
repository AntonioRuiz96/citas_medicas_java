package metaenlace.citas_medicas.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import metaenlace.citas_medicas.entities.Cita;
import metaenlace.citas_medicas.entities.Medico;
import metaenlace.citas_medicas.entities.Paciente;
import metaenlace.citas_medicas.entitiesDTO.CitaDTO;
import metaenlace.citas_medicas.repositories.CitaRepository;
import metaenlace.citas_medicas.repositories.MedicoRepository;
import metaenlace.citas_medicas.repositories.PacienteRepository;
import metaenlace.citas_medicas.service.CitaService;

@Service
public class CitaServiceImpl implements CitaService {
	
	private final CitaRepository citaRepository;
	private final PacienteRepository pacienteRepository;
	private final MedicoRepository medicoRepository;
	private ModelMapper mapper = new ModelMapper();

    @Autowired
    public CitaServiceImpl(CitaRepository citaRepository, PacienteRepository pacienteRepository,
    		MedicoRepository medicoRepository) {
    	this.citaRepository = citaRepository;
    	this.pacienteRepository = pacienteRepository;
    	this.medicoRepository = medicoRepository;
    }
	
	@Override
	public List<CitaDTO> findAllCitas() {
		List<Cita> citas = citaRepository.findAll();
		List<CitaDTO> citasDTO = new ArrayList<CitaDTO>();
		for(Cita c: citas) {
			CitaDTO cit = mapper.map(c, CitaDTO.class);//Listas quedan como atributos null

			citasDTO.add(cit);
		}
		return citasDTO;
	}

	@Override
	public Optional<CitaDTO> findCitaById(Integer id) {
		Optional<CitaDTO> citaDTO =Optional.of(mapper.map(citaRepository.findById(id).get(), CitaDTO.class));
		return citaDTO;
	}

	@Override
	public CitaDTO saveCita(CitaDTO nuevaCita) {//funciona!
		if (nuevaCita != null) {
			Cita cita = new Cita(0, nuevaCita.getCitaFechaHora(), nuevaCita.getCitaMotivoCita(), null, null, null);
			if(nuevaCita.getCitaMedicoUserID() != null && nuevaCita.getCitaPacienteUserID() != null) {
				Optional<Paciente> pacienteExists = pacienteRepository.findById(nuevaCita.getCitaPacienteUserID());
				Optional<Medico> medicoExists = medicoRepository.findById(nuevaCita.getCitaMedicoUserID());
				if(pacienteExists.isPresent() && medicoExists.isPresent()) {
					cita.setPaciente(pacienteExists.get());
					cita.setMedico(medicoExists.get());
					
					cita.setCitaID(citaRepository.save(cita).getCitaID());
					
					pacienteExists.get().getCitas().add(cita);
					pacienteRepository.save(pacienteExists.get());
					
					medicoExists.get().getCitas().add(cita);
					medicoRepository.save(medicoExists.get());
					
					return nuevaCita;
				}
			}
			citaRepository.save(cita);
			return nuevaCita;
		}
		return null;
	}

	@Override
	public String deleteCita(Integer id) {
		if (citaRepository.findById(id).isPresent()) {
			citaRepository.deleteById(id);
			return "Cita eliminada correctamente.";
		}
		return "Error! La Cita no existe";
	}

}
