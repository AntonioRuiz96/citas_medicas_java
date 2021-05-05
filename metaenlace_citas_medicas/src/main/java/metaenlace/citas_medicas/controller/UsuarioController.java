package metaenlace.citas_medicas.controller;

import java.util.List;
import java.util.Optional;

import metaenlace.citas_medicas.entities.Usuario;
import metaenlace.citas_medicas.entitiesDTO.UsuarioDTO;

public interface UsuarioController {

	public List<UsuarioDTO> getUsuarios();

	public Optional<UsuarioDTO> getUsuarioById(Integer id);

	public Usuario addUsuario(UsuarioDTO usuario);

	public String deleteUsuario(Integer id);
	
}
