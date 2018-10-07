package dao;

import interfaces.PacienteI;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.Paciente;


public class PacienteDImpl extends Conexion implements PacienteI{

    @Override
    public void Registrar(Paciente paciente) throws Exception {
        try {
            this.conectar();
            String sql = "INSERT INTO PACIENTE(NOMPAC,APEPAC,SEXPAC,DNIPAC,FNPAC,DIRPAC,UBIPAC) VALUES (?,?,?,?,?,?,?)";
            PreparedStatement ps =  this.getCnx().prepareStatement(sql);
            ps.setString(1, paciente.getNombre());
            ps.setString(2, paciente.getApellido());
            ps.setString(3, paciente.getSexo());
            ps.setString(4, paciente.getDni());
            ps.setDate(5, paciente.getFECHNAC());
            ps.setString(6, paciente.getDireccion());
            ps.setString(7, paciente.getUbicacion());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public void Modificar(Paciente paciente) throws Exception {
        try {
            this.conectar();
            String sql = "UPDATE PACIENTE SET NOMPAC=?,APEPAC=?,SEXPAC=?,DNIPAC=?,FNPAC=?,DIRPAC=?,UBIPAC=? WHERE NUMPAC=?";
            PreparedStatement ps = this.getCnx().prepareStatement(sql);
            ps.setString(1, paciente.getNombre());
            ps.setString(2, paciente.getApellido());
            ps.setString(3, paciente.getSexo());
            ps.setString(4, paciente.getDni());
            ps.setDate(5, paciente.getFECHNAC());
            ps.setString(6, paciente.getDireccion());
            ps.setString(7, paciente.getUbicacion());
            ps.setInt(8, paciente.getCodigo());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public void Eliminar(Paciente paciente) throws Exception {
        try {
            this.conectar();
            String sql = "DELETE FROM PACIENTE WHERE NUMPAC=?";
            PreparedStatement ps = this.getCnx().prepareStatement(sql);
            ps.setString(1, paciente.getUbicacion());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public List<Paciente> Lista() throws Exception {
        List<Paciente> listaPaciente;
        ResultSet rs;
        try {
            this.conectar();
            String sql = "SELECT * FROM PACIENTE";
            PreparedStatement ps = (PreparedStatement) this.getCnx().prepareStatement(sql);
            rs = ps.executeQuery();
            Paciente paciente;
            listaPaciente = new ArrayList();
            while(rs.next()){
                paciente = new Paciente();
                paciente.setCodigo(rs.getInt("NUMPAC"));
                paciente.setNombre(rs.getString("NOMPAC"));
                paciente.setApellido(rs.getString("APEPAC"));
                paciente.setSexo(rs.getString("SEXPAC"));
                paciente.setDni(rs.getString("DNIPAC"));
                paciente.setFECHNAC(rs.getDate("FNPAC"));
                paciente.setDireccion(rs.getString("DIRPAC"));
                paciente.setUbicacion(rs.getString("UBIPAC"));
                listaPaciente.add(paciente);
            }
        } catch (Exception e) {
            throw e;
        }
        return listaPaciente;
    }   
    
}
