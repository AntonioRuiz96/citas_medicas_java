package metaenlace.citas_medicas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import metaenlace.citas_medicas.entities.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Integer> {

}
