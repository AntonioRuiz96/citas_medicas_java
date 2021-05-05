package metaenlace.citas_medicas.controllerImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import metaenlace.citas_medicas.controller.UsuarioController;
import metaenlace.citas_medicas.entities.Usuario;
import metaenlace.citas_medicas.entitiesDTO.UsuarioDTO;
import metaenlace.citas_medicas.service.UsuarioService;


@RestController
public class UsuarioControllerImpl implements UsuarioController{

	private final UsuarioService usuarioService;

    @Autowired
    public UsuarioControllerImpl(UsuarioService usuarioService) {
    	this.usuarioService = usuarioService;
    }
    
	@Override
	@RequestMapping(value = "/usuarios", method = RequestMethod.GET, produces = "application/json")
	public List<UsuarioDTO> getUsuarios() {
		return usuarioService.findAllUsuarios();
	}

	@Override
	@RequestMapping(value = "/usuarios/{id}", method = RequestMethod.GET, produces = "application/json")	
	public Optional<UsuarioDTO> getUsuarioById(@PathVariable Integer id) {
		return usuarioService.findUsuarioById(id);
	}

	@Override
	@RequestMapping(value = "/usuarios/add", method = RequestMethod.POST, produces = "application/json")
	public Usuario addUsuario(@RequestBody UsuarioDTO nuevoUsuario) {
		return usuarioService.saveUsuario(nuevoUsuario);
	}

	@Override
	@RequestMapping(value = "/usuarios/delete/{id}", method = RequestMethod.GET, produces = "application/json")
	public String deleteUsuario(@PathVariable Integer id) {
		return usuarioService.deleteUsuario(id);
	}

}
