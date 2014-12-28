/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sistemasb13.tienda.domain.ubigeo;

import java.io.Serializable;


/**
 *
 * @author Nelson
 */
public class Provincia implements Serializable{
 
	private static final long serialVersionUID = 1L;
	private String coProvincia;
    private String coDepartamento;
    private String noProvincia;

    public Provincia() {
    }
    
    public String getNoProvincia() {
		return noProvincia;
	}

	public void setNoProvincia(String noProvincia) {
		this.noProvincia = noProvincia;
	}

    public Provincia(String coProvincia, String coDepartamento) {
        this.coProvincia = coProvincia;
        this.coDepartamento = coDepartamento;
    }

    public String getCoProvincia() {
        return coProvincia;
    }

    public void setCoProvincia(String coProvincia) {
        this.coProvincia = coProvincia;
    }

    public String getCoDepartamento() {
        return coDepartamento;
    }

    public void setCoDepartamento(String coDepartamento) {
        this.coDepartamento = coDepartamento;
    }
    
}
