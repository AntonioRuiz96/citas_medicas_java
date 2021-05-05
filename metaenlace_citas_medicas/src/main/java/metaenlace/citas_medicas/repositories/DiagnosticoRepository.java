package metaenlace.citas_medicas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import metaenlace.citas_medicas.entities.Diagnostico;

public interface DiagnosticoRepository extends JpaRepository<Diagnostico, Integer> {

}
