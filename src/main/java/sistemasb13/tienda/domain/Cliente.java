package sistemasb13.tienda.domain;

import java.io.Serializable;
import java.util.Date;

public class Cliente implements Serializable {

	private static final long serialVersionUID = 1L;
	private String coCliente;
	private String deNombre;
	private String deApellidoPaterno;
	private String deApellidoMaterno;
	private Date feRegistra;
	private String dirFoto;
	private String coEstado;
	private String coUsuario;

	public String getCoCliente() {
		return coCliente;
	}

	public void setCoCliente(String coCliente) {
		this.coCliente = coCliente;
	}

	public String getDeNombre() {
		return deNombre;
	}

	public void setDeNombre(String deNombre) {
		this.deNombre = deNombre;
	}

	public String getDeApellidoPaterno() {
		return deApellidoPaterno;
	}

	public void setDeApellidoPaterno(String deApellidoPaterno) {
		this.deApellidoPaterno = deApellidoPaterno;
	}

	public String getDeApellidoMaterno() {
		return deApellidoMaterno;
	}

	public void setDeApellidoMaterno(String deApellidoMaterno) {
		this.deApellidoMaterno = deApellidoMaterno;
	}

	public Date getFeRegistra() {
		return feRegistra;
	}

	public void setFeRegistra(Date feRegistra) {
		this.feRegistra = feRegistra;
	}

	public String getCoEstado() {
		return coEstado;
	}

	public void setCoEstado(String coEstado) {
		this.coEstado = coEstado;
	}

	public String getCoUsuario() {
		return coUsuario;
	}

	public void setCoUsuario(String coUsuario) {
		this.coUsuario = coUsuario;
	}

	public String getDirFoto() {
		return dirFoto;
	}

	public void setDirFoto(String dirFoto) {
		this.dirFoto = dirFoto;
	}

	@Override
	public String toString() {
		return "Cliente [coCliente=" + coCliente + ", deNombre=" + deNombre
				+ ", deApellidoPaterno=" + deApellidoPaterno
				+ ", deApellidoMaterno=" + deApellidoMaterno + ", feRegistra="
				+ feRegistra + ", coEstado=" + coEstado + ", coUsuario="
				+ coUsuario + "]";
	}

}
