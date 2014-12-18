package sistemasb13.tienda.services;

import java.util.List;

import sistemasb13.tienda.domain.Usuario;


public interface UsuarioService {

	/**
	 * Retorna la siguiente Pagina a ir*/
	public Usuario logearse(String deLogin, String dePassword);
	
	public List<Usuario> listarUsuarios();
	
	public String actualizarUsuario(Usuario usuario);
	
}
