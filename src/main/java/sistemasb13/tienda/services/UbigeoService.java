package sistemasb13.tienda.services;

import java.util.List;

import sistemasb13.tienda.domain.ubigeo.Departamento;
import sistemasb13.tienda.domain.ubigeo.Provincia;

public interface UbigeoService {

	public List<Departamento> getAllDepartments();
	
	public List<Provincia> getProvinciasByIdDepartment(String coDepartamento);
}
