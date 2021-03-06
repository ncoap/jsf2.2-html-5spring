package sistemasb13.tienda.services.impl;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sistemasb13.tienda.daoibatis.IUbigeo;
import sistemasb13.tienda.domain.ubigeo.Departamento;
import sistemasb13.tienda.domain.ubigeo.Distrito;
import sistemasb13.tienda.domain.ubigeo.Provincia;
import sistemasb13.tienda.services.UbigeoService;

@Service
public class UbigeoServiceImpl implements UbigeoService,Serializable {

	
	private static final long serialVersionUID = 1L;
	@Autowired
	private IUbigeo ubigeoDao;
	
	@Override
	public List<Departamento> getAllDepartments() {
		return ubigeoDao.getAllDepartments();
	}

	@Override
	public List<Provincia> getProvinciasByIdDepartment(String coDepartamento) {
		
		return ubigeoDao.getProvinciasByIdDepartment(coDepartamento);
	}

	@Override
	public List<Distrito> getDistritosByIdProvinciaAndIdDepartment(
			String coProvincia, String coDepartamento) {
		
		HashMap<Object, Object> mapa = new HashMap<Object, Object>();
		mapa.put("coProvincia",coProvincia);
		mapa.put("coDepartamento", coDepartamento);
		
		return ubigeoDao.getDistritosByIdProvinciaAndIdDepartment(mapa);
	}
	

}
