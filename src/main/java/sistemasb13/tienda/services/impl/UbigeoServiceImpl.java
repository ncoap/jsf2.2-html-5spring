package sistemasb13.tienda.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sistemasb13.tienda.daoibatis.IUbigeo;
import sistemasb13.tienda.domain.ubigeo.Departamento;
import sistemasb13.tienda.services.UbigeoService;

@Service
public class UbigeoServiceImpl implements UbigeoService {

	@Autowired
	private IUbigeo ubigeoDao;
	
	@Override
	public List<Departamento> getAllDepartments() {
		return ubigeoDao.getAllDepartments();
	}

}
