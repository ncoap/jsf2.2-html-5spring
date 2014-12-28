package sistemasb13.tienda.dao.impl;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.jsf.FacesContextUtils;

import sistemasb13.tienda.dao.UsuarioDao;
import sistemasb13.tienda.domain.Usuario;

@SuppressWarnings("deprecation")
@Repository
public class UsuarioDaoImpl implements UsuarioDao, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// acceso para JDBC CON spring jdbc
	private static final Logger log = Logger.getLogger(UsuarioDaoImpl.class);


	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Usuario logearse(String deLogin, String dePassword) {

		String sql = "SELECT * FROM USUARIO WHERE DE_LOGIN = ? AND DE_PASSWORD =?";
		Usuario usuario= (Usuario) jdbcTemplate.queryForObject(sql,
					new Object[] { deLogin, dePassword },
					new BeanPropertyRowMapper(Usuario.class));
		return usuario;

	}


	@Override
	public List<Usuario> listarUsuarios() {

		String query = "SELECT * FROM USUARIO";
		List<Usuario> usuarios = new ArrayList<Usuario>();
		usuarios = jdbcTemplate.query(query,
				new ParameterizedRowMapper<Usuario>() {
					public Usuario mapRow(ResultSet rs, int rowNum)
							throws SQLException {

						Usuario usuario = new Usuario();
						usuario.setCoUsuario(rs.getString(1));
						usuario.setDeLogin(rs.getString(2));
						usuario.setDePassword(rs.getString(3));
						usuario.setFeRegistra(rs.getDate(4));
						usuario.setCoEstado(rs.getString(5));

						return usuario;
					}
				});

		return usuarios;
	}

	@Override
	public Usuario getUsuario(String coUsuario) {

		String sql = "SELECT * FROM USUARIO WHERE CO_USUARIO=?";

		@SuppressWarnings({ "unchecked", "rawtypes" })
		Usuario usuario = (Usuario) jdbcTemplate.queryForObject(sql,
				new Object[] { coUsuario }, new BeanPropertyRowMapper(
						Usuario.class));

		log.debug("Usuario Encontrado: " + usuario);

		return usuario;
	}

	@Override
	public String updateUsuario(Usuario usuario) {
		String sql = "UPDATE USUARIO SET DE_LOGIN = ? ,DE_PASSWORD =?,FE_REGISTRA=?, CO_ESTADO=? WHERE "
				+ "CO_USUARIO =?";

		int msj = jdbcTemplate.update(
				sql,
				new Object[] { usuario.getDeLogin(), usuario.getDePassword(),
						usuario.getFeRegistra(), usuario.getCoEstado(),
						usuario.getCoUsuario() });

		log.debug("ACTUALIZADO " + usuario.getCoUsuario() + "- COD_MENSAJE: "
				+ msj);
		return "ACTUALIZADO " + msj;
	}

	@Override
	public String deleteUsuario(String coUsuario) {
		String sql = "DELETE FROM USUARIO WHERE CO_USUARIO =?";

		int msj = jdbcTemplate.update(sql, new Object[] { coUsuario });
		log.debug("USUARIO ELIMINADO " + coUsuario + " - COD_MENSAJE: " + msj);
		return "";
	}

	// FORMA ACTUAL DE MOSTRAR LOS VALORES

	// @SuppressWarnings("rawtypes")
	// public List<Employee> findAll(){
	//
	// jdbcTemplate = new JdbcTemplate(dataSource);
	// String sql = "SELECT * FROM EMPLOYEE";
	//
	// List<Employee> employees = new ArrayList<Employee>();
	//
	// List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
	// for (Map row : rows) {
	// Employee employee = new Employee();
	// employee.setId(Integer.parseInt(String.valueOf(row.get("ID"))));
	// employee.setName((String)row.get("NAME"));
	// employee.setAge(Integer.parseInt(String.valueOf(row.get("AGE"))));
	// employees.add(employee);
	// }
	//
	// return employees;
	// }

}
