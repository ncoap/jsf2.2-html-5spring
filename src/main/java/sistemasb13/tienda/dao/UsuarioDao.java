package sistemasb13.tienda.dao;

import java.util.List;

import sistemasb13.tienda.domain.Usuario;


public interface UsuarioDao {
	
	public Usuario logearse(String deLogin, String dePassword);
	public List<Usuario> listarUsuarios();
	public Usuario getUsuario(String coUsuario);
	public String updateUsuario(Usuario usuario);
	public String deleteUsuario(String coUsuario);

}
