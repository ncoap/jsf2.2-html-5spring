package sistemasb13.tienda.services;

import java.util.List;

import sistemasb13.tienda.domain.Cliente;


public interface ClienteService {

	public List<Cliente> listarCliente();
	public String actualizarCliente(Cliente cliente);
	public String registrarCliente(Cliente cliente);
	
	
}
