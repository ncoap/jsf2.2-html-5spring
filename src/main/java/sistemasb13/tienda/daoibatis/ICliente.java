package sistemasb13.tienda.daoibatis;

import java.util.List;

import sistemasb13.tienda.domain.Cliente;

public interface ICliente {

	public int addClient(Cliente cliente);
	
	public int updateClient(Cliente cliente);
	
	public List<Cliente> getClientes();

}
