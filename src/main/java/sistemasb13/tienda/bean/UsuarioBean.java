package sistemasb13.tienda.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import sistemasb13.tienda.domain.Usuario;
import sistemasb13.tienda.services.UsuarioService;

@Component
@Scope("session")
public class UsuarioBean implements Serializable {

	private static final Logger log = Logger.getLogger(UsuarioBean.class);
	private static final long serialVersionUID = 1L;
	private Usuario usuario;
	private List<Usuario> usuarios;

	@Autowired
	private UsuarioService usuarioService;

	@PostConstruct
	public void initialize() {
		usuario = new Usuario();
		usuario.setDeLogin("holitas");
		usuarios = new ArrayList<Usuario>();
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	public void listarUsuarios() {
		usuarios = usuarioService.listarUsuarios();
		log.debug("lista de usuario llenada " + usuarios);
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}
	
	public String logearse(){
		Usuario usuario = usuarioService.logearse(this.usuario.getDeLogin(), this.usuario.getDePassword());
		log.debug(usuario);
		if(usuario!=null){
			this.usuario = usuario;
			return "views/home";
		}
		else {
			this.usuario =  new Usuario();
			return "index";	
		}
	}


}
