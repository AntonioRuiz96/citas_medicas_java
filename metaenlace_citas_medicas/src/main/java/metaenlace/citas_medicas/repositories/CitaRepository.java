package metaenlace.citas_medicas.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import metaenlace.citas_medicas.entities.Cita;

public interface CitaRepository extends JpaRepository<Cita, Integer>{

}
