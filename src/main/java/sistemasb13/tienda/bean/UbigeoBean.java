package sistemasb13.tienda.bean;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import sistemasb13.tienda.domain.ubigeo.Departamento;
import sistemasb13.tienda.domain.ubigeo.Distrito;
import sistemasb13.tienda.domain.ubigeo.Provincia;
import sistemasb13.tienda.services.UbigeoService;

@Component
@Scope("session")
public class UbigeoBean {
	
	private Departamento departamento;
	private Provincia provincia;
	private Distrito distrito;
	
	List<Departamento> departamentos;
	List<Provincia> provincias;
	List<Distrito> distritos;
	
	@Autowired
	UbigeoService ubigeoService;
	
	public UbigeoBean(){
		
		departamento = new Departamento();
		provincia =  new Provincia();
		distrito = new Distrito();
		
		departamentos = new ArrayList<Departamento>();
		provincias = new ArrayList<Provincia>();
		distritos = new ArrayList<Distrito>();
		
	}
	
	
	public void getAllDepartments(){
		
		departamentos = ubigeoService.getAllDepartments();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


	public Departamento getDepartamento() {
		return departamento;
	}


	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}


	public Provincia getProvincia() {
		return provincia;
	}


	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}


	public Distrito getDistrito() {
		return distrito;
	}


	public void setDistrito(Distrito distrito) {
		this.distrito = distrito;
	}


	public List<Departamento> getDepartamentos() {
		return departamentos;
	}


	public void setDepartamentos(List<Departamento> departamentos) {
		this.departamentos = departamentos;
	}


	public List<Provincia> getProvincias() {
		return provincias;
	}


	public void setProvincias(List<Provincia> provincias) {
		this.provincias = provincias;
	}


	public List<Distrito> getDistritos() {
		return distritos;
	}


	public void setDistritos(List<Distrito> distritos) {
		this.distritos = distritos;
	}
	
}
