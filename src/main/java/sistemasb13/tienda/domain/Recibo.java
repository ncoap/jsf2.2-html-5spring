package sistemasb13.tienda.domain;

import java.util.Date;

public class Recibo {

	private String coRecibo;
	private String coCliente;
	private String deRecibo;
	private String nuComprobante;
	private Date feRegistro;
	private double subTotal;
	private double igv;
	private double total;
	private String coOperacion;
	private String coEstado;

	public String getCoRecibo() {
		return coRecibo;
	}

	public void setCoRecibo(String coRecibo) {
		this.coRecibo = coRecibo;
	}

	public String getCoCliente() {
		return coCliente;
	}

	public void setCoCliente(String coCliente) {
		this.coCliente = coCliente;
	}

	public String getDeRecibo() {
		return deRecibo;
	}

	public void setDeRecibo(String deRecibo) {
		this.deRecibo = deRecibo;
	}

	public String getNuComprobante() {
		return nuComprobante;
	}

	public void setNuComprobante(String nuComprobante) {
		this.nuComprobante = nuComprobante;
	}

	public Date getFeRegistro() {
		return feRegistro;
	}

	public void setFeRegistro(Date feRegistro) {
		this.feRegistro = feRegistro;
	}

	public double getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}

	public double getIgv() {
		return igv;
	}

	public void setIgv(double igv) {
		this.igv = igv;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public String getCoOperacion() {
		return coOperacion;
	}

	public void setCoOperacion(String coOperacion) {
		this.coOperacion = coOperacion;
	}

	public String getCoEstado() {
		return coEstado;
	}

	public void setCoEstado(String coEstado) {
		this.coEstado = coEstado;
	}

}
