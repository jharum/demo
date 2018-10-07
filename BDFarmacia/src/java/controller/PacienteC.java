package controller;

import dao.PacienteDImpl;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import modelo.Paciente;

@Named(value = "pacienteC")
@SessionScoped
public class PacienteC implements Serializable {

    Paciente paciente = new Paciente();
    private List<Paciente> LstPaciente;
    PacienteDImpl dao;
    
    @PostConstruct
    public void iniciar() {
        try {
            listar();
            limpiar();
        } catch (Exception e) {
            
        }

    }

    public void listar() throws Exception {
        try {
            dao = new PacienteDImpl();
            LstPaciente = dao.Lista();
        } catch (Exception e) {
            throw e;
        }
    }

    public void ingresar() throws Exception {
        try {
            dao = new PacienteDImpl();
            dao.Registrar(paciente);
            listar();
            limpiar();
        } catch (Exception e) {
            throw e;
        }

    }

    public void actualizar() throws Exception {
        try {
            dao = new PacienteDImpl();
            dao.Modificar(paciente);
            listar();
            limpiar();
        } catch (Exception e) {
            throw e;
        }

    }

    public void eliminar() throws Exception {
        try {
            dao = new PacienteDImpl();
            dao.Eliminar(paciente);
            listar();
            limpiar();
        } catch (Exception e) {
            throw e;
        }

    }

    public void limpiar() {
        paciente = new Paciente();
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public List<Paciente> getLstPaciente() {
        return LstPaciente;
    }

    public void setLstPaciente(List<Paciente> LstPaciente) {
        this.LstPaciente = LstPaciente;
    }

}
