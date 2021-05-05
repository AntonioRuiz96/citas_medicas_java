package metaenlace.citas_medicas.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import metaenlace.citas_medicas.entities.Usuario;
import metaenlace.citas_medicas.entitiesDTO.UsuarioDTO;
import metaenlace.citas_medicas.repositories.UsuarioRepository;
import metaenlace.citas_medicas.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	private final UsuarioRepository usuarioRepository;
	private ModelMapper mapper = new ModelMapper();
    @Autowired
    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
    	this.usuarioRepository = usuarioRepository;
    }

	@Override
	public List<UsuarioDTO> findAllUsuarios() {
		List<Usuario> usuarios = usuarioRepository.findAll();
		List<UsuarioDTO> usuariosDTO = new ArrayList<UsuarioDTO>();
		for(Usuario u: usuarios) {
			usuariosDTO.add(mapper.map(u, UsuarioDTO.class));
		}
		return usuariosDTO;
	}

	@Override
	public Optional<UsuarioDTO> findUsuarioById(Integer id) {
		Optional<Usuario> usuario = usuarioRepository.findById(id);
		if (usuario.isPresent()) {
			Optional<UsuarioDTO> usuarioDTO = Optional.of(mapper.map(usuario.get(), UsuarioDTO.class));		
			return usuarioDTO;
		}else{
			return null;
			}
		}

	@Override
	public Usuario saveUsuario(UsuarioDTO nuevoUsuario) {
		if (nuevoUsuario != null) {
			Usuario usuario = new Usuario (0, nuevoUsuario.getUsuarioUsuario(),
					nuevoUsuario.getUsuarioNombre(), nuevoUsuario.getUsuarioApellidos(),
					nuevoUsuario.getUsuarioClave());
			return usuarioRepository.save(usuario);
		}
		return null;
	}

	@Override
	public String deleteUsuario(Integer id) {
		if (usuarioRepository.findById(id).isPresent()) {
			usuarioRepository.deleteById(id);
			return "Usuario eliminado correctamente.";
		}
		return "Error! El Usuario no existe";
	}

}
