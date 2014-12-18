package sistemasb13.tienda.domain;

import java.io.Serializable;
import java.util.Date;

public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	private String coUsuario;
	private String deLogin;
	private String dePassword;
	private Date feRegistra;
	private String coEstado;

	public String getCoUsuario() {
		return coUsuario;
	}

	public void setCoUsuario(String coUsuario) {
		this.coUsuario = coUsuario;
	}

	public String getDeLogin() {
		return deLogin;
	}

	public void setDeLogin(String deLogin) {
		this.deLogin = deLogin;
	}

	public String getDePassword() {
		return dePassword;
	}

	public void setDePassword(String dePassword) {
		this.dePassword = dePassword;
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

	@Override
	public String toString() {
		return "Usuario [coUsuario=" + coUsuario + ", deLogin=" + deLogin
				+ ", dePassword=" + dePassword + ", feRegistra=" + feRegistra
				+ ", coEstado=" + coEstado + "]";
	}
	
}
