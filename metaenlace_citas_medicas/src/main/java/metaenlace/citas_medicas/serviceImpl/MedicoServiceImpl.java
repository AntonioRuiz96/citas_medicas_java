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
import metaenlace.citas_medicas.entitiesDTO.MedicoDTO;
import metaenlace.citas_medicas.repositories.MedicoRepository;
import metaenlace.citas_medicas.repositories.PacienteRepository;
import metaenlace.citas_medicas.service.MedicoService;

@Service
public class MedicoServiceImpl implements MedicoService{

	private final MedicoRepository medicoRepository;
	private final PacienteRepository pacienteRepository;
	private ModelMapper mapper = new ModelMapper();

    @Autowired
    public MedicoServiceImpl(MedicoRepository medicoRepository, PacienteRepository pacienteRepository) {
    	this.medicoRepository = medicoRepository;
    	this.pacienteRepository = pacienteRepository;
    }
    
	@Override
	public List<MedicoDTO> findAllMedicos() {
		List<Medico> medicos = medicoRepository.findAll();
		List<MedicoDTO> medicosDTO = new ArrayList<MedicoDTO>();
		for(Medico m: medicos) {
			MedicoDTO med = mapper.map(m, MedicoDTO.class);//Listas quedan como atributos null
			List<Integer> pacientesID = new ArrayList<Integer>(); 
			for(Paciente p: m.getPacientes()) {
				pacientesID.add(p.getUserID());
			}
			med.setMedicoPacientesUserID(pacientesID);
			
			List<Integer> citasID = new ArrayList<Integer>(); 
			for(Cita c: m.getCitas()) {
				citasID.add(c.getCitaID());
			}
			med.setMedicoCitasCitaID(citasID);

			medicosDTO.add(med);
		}
		return medicosDTO;
	}

	@Override
	public Optional<MedicoDTO> findMedicoById(Integer id) {
		Optional<Medico> medico = medicoRepository.findById(id);
		if(medico.isPresent()) {
		Optional<MedicoDTO> medicoDTO =Optional.of(mapper.map(medico.get(), MedicoDTO.class));
		
		List<Integer> pacientes= new ArrayList<Integer>();
	   	 for (Paciente p: medico.get().getPacientes()) {
	   		 pacientes.add(p.getUserID());
	   	 }
	   	medicoDTO.get().setMedicoPacientesUserID(pacientes);
	   	
	   	List<Integer> citas= new ArrayList<Integer>();
	   	 for (Cita c: medico.get().getCitas()) {
	   		 pacientes.add(c.getCitaID());
	   	 }
		medicoDTO.get().setMedicoCitasCitaID(citas);

		return medicoDTO;
		}else {
			return null;
		}
	}

	@Override
	public MedicoDTO saveMedico(MedicoDTO nuevoMedico) {
		if (nuevoMedico != null) {
			List<Paciente> listaPacientes = new ArrayList<Paciente>();
			List<Cita> listaCitas = new ArrayList<Cita>();
			Medico medicoSave = new Medico(0, nuevoMedico.getMedicoUsuario(),
					nuevoMedico.getMedicoNombre(), nuevoMedico.getMedicoApellidos(),
					nuevoMedico.getMedicoClave(), nuevoMedico.getMedicoNumColegiado(),
					listaPacientes, listaCitas);
			medicoSave.setUserID(medicoRepository.save(medicoSave).getUserID());
			System.out.println("ID del usuario guardado:" +medicoSave.getUserID());
			if(nuevoMedico.getMedicoPacientesUserID() != null) {
			
			for(Integer IDpaciente: nuevoMedico.getMedicoPacientesUserID()) {
				Optional<Paciente> pacienteExists = pacienteRepository.findById(IDpaciente);
				if (pacienteExists.isPresent()) {
					pacienteExists.get().getMedicos().add(medicoSave);
					pacienteRepository.save(pacienteExists.get());
				}
				
				}
			}
			
			//Des comentar dependiendo de como lo vaya a hacer
			//Creo que se deberia hacer desde cita.
			/*if(nuevoMedico.getMedicoCitasCitaID().size()>0) {
			
			for(Integer IDcita: nuevoMedico.getMedicoCitasCitaID()) {
				Optional<Cita> citaExists = citaRepository.findById(IDcita);
				if (citaExists.isPresent()) {
					Cita b = new Cita();
					b.setCitaID(IDcita);
					listaCitas.add(b);
					}
				}
			}*/
						
			return nuevoMedico;
		}else {
			return null;
		}
		
	}

	@Override
	public String deleteMedico(Integer id) {
		if (medicoRepository.findById(id).isPresent()) {
			medicoRepository.deleteById(id);
			return "Medico eliminado correctamente.";
		}
		return "Error! El Medico no existe";
	}

}
