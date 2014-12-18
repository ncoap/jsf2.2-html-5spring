package sistemasb13.tienda.services.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sistemasb13.tienda.dao.UsuarioDao;
import sistemasb13.tienda.domain.Usuario;
import sistemasb13.tienda.services.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService,Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private UsuarioDao usuarioDao;

	@Override
	public Usuario logearse(String deLogin, String dePassword) {

		Usuario usuario = usuarioDao.logearse(deLogin, dePassword);

		return usuario;

	}

	public UsuarioDao getUsuarioDao() {
		return usuarioDao;
	}

	public void setUsuarioDao(UsuarioDao usuarioDao) {
		this.usuarioDao = usuarioDao;
	}

	@Override
	public List<Usuario> listarUsuarios() {
		return usuarioDao.listarUsuarios();
	}

	@Override
	public String actualizarUsuario(Usuario usuario) {
		return usuarioDao.updateUsuario(usuario);
	}
	

}
