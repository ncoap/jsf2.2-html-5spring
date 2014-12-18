package sistemasb13.tienda.dao;

import java.util.List;

import sistemasb13.tienda.domain.Cliente;

public interface ClienteDao {

	public List<Cliente> listarClientes();
	public String actualizarCliente(Cliente cliente);
	public String registrarCliente(Cliente cliente);
}
