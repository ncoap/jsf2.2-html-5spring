/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sistemasb13.tienda.domain.ubigeo;


/**
 *
 * @author nelson
 */
public class Departamento {
    private String coDepartamento;    
    private String noDepartamento;

    public Departamento() {
    }

    public Departamento(String coDepartamento) {
        this.coDepartamento = coDepartamento;
    }

    public String getCoDepartamento() {
        return coDepartamento;
    }

    public void setCoDepartamento(String coDepartamento) {
        this.coDepartamento = coDepartamento;
    }

    public String getNoDepartamento() {
        return noDepartamento;
    }

    public void setNoDepartamento(String noDepartamento) {
        this.noDepartamento = noDepartamento;
    }
}
