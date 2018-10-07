
package controller;

import dao.ProvedorD;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import modelo.ProvedorM;



@Named(value = "ProvedorC")
@SessionScoped
public class ProvedorC  implements Serializable{
     
    ProvedorM provedor = new ProvedorM();
    private ProvedorM selectedProvedor;
    private List<ProvedorM> lstProvedor;
    
    @PostConstruct
    public void init(){
        try {
            listarProvedor();
        } catch (Exception e) {
        }
    }
    private void listarProvedor() throws Exception{
        ProvedorD dao;
                try{
                dao = new ProvedorD();
                lstProvedor =  dao.listar();      
                }catch (Exception e){
                    throw e;
                }
    }
    
    public void guardarProvedor() throws Exception{
        ProvedorD dao;
        try {
            dao = new ProvedorD();
            dao.guardarProvedor(provedor);
            listarProvedor();
             FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "AGREGADO", "Correctamente"));
            limpiarProvedor();
        } catch (Exception e) {
             FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "ERROR", "No se pudo agregar"));

        }
        
    }
    public void modificarProvedor() {
        ProvedorD dao;
        try {
            dao = new ProvedorD();
            dao.Modificar(selectedProvedor);
            listarProvedor();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "MODIFICADO", "Correctamente"));
            limpiarProvedor();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "ERROR", "No se pudo modificar"));
        }
}
    public void eliminarProvedor() throws Exception {
        ProvedorD dao;
        try {
            dao = new ProvedorD();
            dao.Eliminar(selectedProvedor);
            lstProvedor();
             FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "ELIMINADO", "Correctamente"));
        } catch (Exception e) {
           
            throw e;
        }
    }
     private void lstProvedor() throws Exception {
        ProvedorD dao;
        try {
            dao = new ProvedorD();
            lstProvedor = dao.listar();
        } catch (Exception e) {
            throw e;
        }
   }

    public ProvedorM getProvedor() {
        return provedor;
    }

    public void setProvedor(ProvedorM provedor) {
        this.provedor = provedor;
    }

    public ProvedorM getSelectedProvedor() {
        return selectedProvedor;
    }

    public void setSelectedProvedor(ProvedorM selectedProvedor) {
        this.selectedProvedor = selectedProvedor;
    }

    public List<ProvedorM> getLstProvedor() {
        return lstProvedor;
    }

    public void setLstProvedor(List<ProvedorM> lstProvedor) {
        this.lstProvedor = lstProvedor;
    }

  

    private void limpiarProvedor() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
     
     
     }