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
import metaenlace.citas_medicas.entitiesDTO.PacienteDTO;
import metaenlace.citas_medicas.repositories.MedicoRepository;
import metaenlace.citas_medicas.repositories.PacienteRepository;
import metaenlace.citas_medicas.service.PacienteService;

@Service
public class PacienteServiceImpl implements PacienteService{
	
	private final PacienteRepository pacienteRepository;
	private final MedicoRepository medicoRepository;

	private ModelMapper mapper = new ModelMapper();

	
    @Autowired
    public PacienteServiceImpl(PacienteRepository pacienteRepository, MedicoRepository medicoRepository) {
    	this.pacienteRepository = pacienteRepository;
    	this.medicoRepository = medicoRepository;
    }
	
	@Override
	public List<PacienteDTO> findAllPacientes() {
		List<Paciente> pacientes = pacienteRepository.findAll();
		List<PacienteDTO> pacientesDTO = new ArrayList<PacienteDTO>();
		for(Paciente p: pacientes) {
			PacienteDTO pac = mapper.map(p, PacienteDTO.class);
			List<Integer> medicosID = new ArrayList<Integer>(); 
			for(Medico m: p.getMedicos()) {
				medicosID.add(m.getUserID());
			}
			pac.setPacienteMedicosUserID(medicosID);
			
			List<Integer> citasID = new ArrayList<Integer>(); 
			for(Cita c: p.getCitas()) {
				citasID.add(c.getCitaID());
			}
			pac.setPacienteCitasCitaID(citasID);

			pacientesDTO.add(pac);
		}
		return pacientesDTO;
	}

	@Override
	public Optional<PacienteDTO> findPacienteById(Integer id) {
		Optional<Paciente> paciente = pacienteRepository.findById(id);
		if(paciente.isPresent()) {
		Optional<PacienteDTO> pacienteDTO =Optional.of(mapper.map(paciente.get(), PacienteDTO.class));
		
		List<Integer> medicos= new ArrayList<Integer>();
	   	 for (Medico m: paciente.get().getMedicos()) {
	   		 medicos.add(m.getUserID());
	   	 }
	   	pacienteDTO.get().setPacienteMedicosUserID(medicos);
	   	
	   	List<Integer> citas= new ArrayList<Integer>();
	   	 for (Cita c: paciente.get().getCitas()) {
	   		 medicos.add(c.getCitaID());
	   	 }
		pacienteDTO.get().setPacienteCitasCitaID(citas);

		return pacienteDTO;
		}else {
			return null;
		}
	}

	@Override
	public PacienteDTO savePaciente(PacienteDTO nuevoPaciente) {
		if (nuevoPaciente != null) {
			List<Medico> listaMedicos = new ArrayList<Medico>();
			if(nuevoPaciente.getPacienteMedicosUserID() != null) {
			
			for(Integer IDmedico: nuevoPaciente.getPacienteMedicosUserID()) {
				Optional<Medico> medicoExists = medicoRepository.findById(IDmedico);
				if (medicoExists.isPresent()) {
					Medico a = new Medico();
					a.setUserID(IDmedico);
					listaMedicos.add(a);
				}
				
				}
			}
			
			List<Cita> listaCitas = new ArrayList<Cita>();
			
			Paciente pacienteSave = new Paciente(0, nuevoPaciente.getPacienteUsuario(),
					nuevoPaciente.getPacienteNombre(), nuevoPaciente.getPacienteApellidos(),
					nuevoPaciente.getPacienteClave(), nuevoPaciente.getPacienteNSS(), nuevoPaciente.getPacienteNumTarjeta(),
					nuevoPaciente.getPacienteTelefono(), nuevoPaciente.getPacienteDireccion(), listaMedicos, listaCitas);
			pacienteRepository.save(pacienteSave);
			
			return nuevoPaciente;
		}else {
			return null;
		}
	}

	@Override
	public String deletePaciente(Integer id) {
		if (pacienteRepository.findById(id).isPresent()) {
			pacienteRepository.deleteById(id);
			return "Paciente eliminado correctamente.";
		}
		return "Error! El Paciente no existe";
	}

}
