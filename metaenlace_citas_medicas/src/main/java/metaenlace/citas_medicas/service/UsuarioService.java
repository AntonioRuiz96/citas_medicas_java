package metaenlace.citas_medicas.service;

import java.util.List;
import java.util.Optional;

import metaenlace.citas_medicas.entities.Usuario;
import metaenlace.citas_medicas.entitiesDTO.UsuarioDTO;

public interface UsuarioService {
	public List<UsuarioDTO> findAllUsuarios();

	public Optional<UsuarioDTO> findUsuarioById(Integer id);

	public Usuario saveUsuario(UsuarioDTO nuevoUsuario);

	public String deleteUsuario(Integer id);

}
