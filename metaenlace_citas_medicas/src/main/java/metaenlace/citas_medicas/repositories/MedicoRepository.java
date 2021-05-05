package metaenlace.citas_medicas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import metaenlace.citas_medicas.entities.Medico;

public interface MedicoRepository extends JpaRepository<Medico, Integer>{

}
