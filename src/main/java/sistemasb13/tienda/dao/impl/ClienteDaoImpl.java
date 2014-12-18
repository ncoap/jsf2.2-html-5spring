package sistemasb13.tienda.dao.impl;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.stereotype.Repository;

import sistemasb13.tienda.dao.ClienteDao;
import sistemasb13.tienda.domain.Cliente;

@SuppressWarnings("deprecation")
@Repository
public class ClienteDaoImpl implements ClienteDao, Serializable {

	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(ClienteDaoImpl.class);

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Cliente> listarClientes() {

		log.debug("LISTAR CLIENTE FROM DAO");
		String query = "SELECT * FROM CLIENTE";
		List<Cliente> clientes = new ArrayList<Cliente>();
		clientes = jdbcTemplate.query(query,
				new ParameterizedRowMapper<Cliente>() {
					public Cliente mapRow(ResultSet rs, int rowNum)
							throws SQLException {

						Cliente cliente = new Cliente();
						cliente.setCoCliente(rs.getString(1));
						cliente.setDeNombre(rs.getString(2));
						cliente.setDeApellidoPaterno(rs.getString(3));
						cliente.setDeApellidoMaterno(rs.getString(4));
						cliente.setFeRegistra(rs.getDate(5));
						cliente.setCoEstado(rs.getString(6));
						cliente.setCoUsuario("");

						return cliente;
					}
				});

		return clientes;
	}

	@Override
	public String actualizarCliente(Cliente cliente) {
		String sql = "UPDATE CLIENTE SET DE_NOMBRE =?,DE_APELLIDO_PATERNO=?, "
				+ "DE_APELLIDO_MATERNO=?,FE_REGISTRA=?,CO_ESTADO=? WHERE "
				+ "CO_CLIENTE =?";

		int msj = jdbcTemplate.update(
				sql,
				new Object[] { 
						cliente.getDeNombre(),
						cliente.getDeApellidoPaterno(),
						cliente.getDeApellidoMaterno(),
						cliente.getFeRegistra(), 
						cliente.getCoEstado(),
						cliente.getCoCliente()});

		log.debug("ACTUALIZADO " + cliente.getCoCliente() + "- COD_MENSAJE: "
				+ msj);
		return "OK";

	}

	@Override
	public String registrarCliente(Cliente cliente) {
		String sql = "INSERT INTO CLIENTE VALUES (?,?,?,?,?,?,?)";

		int msj = jdbcTemplate.update(
				sql,
				new Object[] { 
						cliente.getCoCliente(),
						cliente.getDeNombre(),
						cliente.getDeApellidoPaterno(),
						cliente.getDeApellidoMaterno(),
						cliente.getFeRegistra(), 
						cliente.getCoEstado(),
						cliente.getCoUsuario()
						});

		log.debug("INSERTADO " + cliente.getCoCliente() + "- COD_MENSAJE: "
				+ msj);
		return "OK";
	}

}
