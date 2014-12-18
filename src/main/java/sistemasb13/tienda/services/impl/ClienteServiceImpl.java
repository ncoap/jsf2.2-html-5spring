package sistemasb13.tienda.services.impl;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sistemasb13.tienda.domain.Cliente;
import sistemasb13.tienda.services.ClienteService;
import sistemasb13.tienda.daoibatis.ICliente;

@Service
public class ClienteServiceImpl implements ClienteService,Serializable {

	
	private static final long serialVersionUID = 1L;

	private static final Logger log = Logger.getLogger(ClienteServiceImpl.class);
	
	@Autowired
	private ICliente clienteDao;
	
	@Override
	public List<Cliente> listarCliente() {
		return clienteDao.getClientes();
	}

	@Override
	public String actualizarCliente(Cliente cliente) {
		int result = clienteDao.updateClient(cliente);
		log.debug("Resultado Consulta Ibatis"+result);
		String mensaje="KO";
		if(result >= 1){
			mensaje = "OK";
		}
		return mensaje;
	}

	@Override
	public String registrarCliente(Cliente cliente) {
		int result = clienteDao.addClient(cliente);
		String mensaje="KO";
		if(result >= 1){
			mensaje = "OK";
		}
		return mensaje;
	}

}
