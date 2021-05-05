package metaenlace.citas_medicas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import metaenlace.citas_medicas.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

}
