/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sistemasb13.tienda.domain.ubigeo;


/**
 *
 * @author Nelson
 */
public class Distrito {
    private String coDistrito;
    private String coProvincia;
    private String coDepartamento;
    private String noDistrito;
    
	public Distrito() {
    }

    public Distrito(String coDistrito, String coProvincia, String coDepartamento) {
        this.coDistrito = coDistrito;
        this.coProvincia = coProvincia;
        this.coDepartamento = coDepartamento;
    }
    
    public String getNoDistrito() {
		return noDistrito;
	}

	public void setNoDistrito(String noDistrito) {
		this.noDistrito = noDistrito;
	}

    public String getCoDistrito() {
        return coDistrito;
    }

    public void setCoDistrito(String coDistrito) {
        this.coDistrito = coDistrito;
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
