package sistemasb13.tienda.daoibatis;

import java.util.HashMap;
import java.util.List;

import sistemasb13.tienda.domain.ubigeo.Departamento;
import sistemasb13.tienda.domain.ubigeo.Distrito;
import sistemasb13.tienda.domain.ubigeo.Provincia;

public interface IUbigeo {

	public List<Departamento> getAllDepartments();
	public List<Provincia> getProvinciasByIdDepartment(String coDepartamento);
	public List<Distrito> getDistritosByIdProvinciaAndIdDepartment(HashMap<Object, Object> mapa);
}
