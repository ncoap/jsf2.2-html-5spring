package sistemasb13.tienda.domain;

import java.io.Serializable;
import java.util.Date;

public class Articulo implements Serializable {

	private static final long serialVersionUID = 1L;
	private String coArticulo;
	private String noArticulo;
	private String deMarca;
	private double precioVenta;
	private Date feRegistra;
	private String coEstado;

	public String getCoArticulo() {
		return coArticulo;
	}

	public void setCoArticulo(String coArticulo) {
		this.coArticulo = coArticulo;
	}

	public String getNoArticulo() {
		return noArticulo;
	}

	public void setNoArticulo(String noArticulo) {
		this.noArticulo = noArticulo;
	}

	public String getDeMarca() {
		return deMarca;
	}

	public void setDeMarca(String deMarca) {
		this.deMarca = deMarca;
	}

	public double getPrecioVenta() {
		return precioVenta;
	}

	public void setPrecioVenta(double precioVenta) {
		this.precioVenta = precioVenta;
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

}
