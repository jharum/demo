package dao;

import interfaces.IProvedor;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.ProvedorM;

public class ProvedorD extends Dao implements IProvedor {

    public void guardarProvedor(ProvedorM provedor) throws SQLException, ClassNotFoundException, Exception {
        try {
            this.Conectar();
            String sql = "INSERT INTO PROVEEDOR (RAZPROV,RUCPROV,DIRPROV,TELFPROV,NUMUBI) VALUES (?,?,?,?,?)";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setString(1, provedor.getRAZPROV());
            ps.setString(2, provedor.getRUCPROV());
            ps.setString(3, provedor.getDIRPROV());
            ps.setString(4, provedor.getTELFPROV());
            ps.setString(5, provedor.getNUMUBI());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
        }
        this.Cerrar();
    }

    @Override
    public void Modificar(ProvedorM proveedor) throws Exception {
        try {
            this.Conectar();
            String sql = "UPDATE Proveedor set  RAZPROV=?, RUCPROV=?, DIRPROV=?, TELFPROV=?, NUMUBI=?  where NUMPROV=?";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setString(1, proveedor.getRAZPROV());
            ps.setString(2, proveedor.getRUCPROV());
            ps.setString(3, proveedor.getDIRPROV());
            ps.setString(4, proveedor.getTELFPROV());
            ps.setString(5, proveedor.getNUMUBI());
            ps.setString(6, proveedor.getNUMPROV());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }

    @Override
    public void Eliminar(ProvedorM proveedor) throws Exception {

        this.Conectar();
        try {
            this.Conectar();
            String sql = "DELETE FROM PROVEEDOR WHERE NUMPROV= ?";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setString(1, proveedor.getNUMPROV());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }

    @Override
    public List<ProvedorM> listar() throws Exception {
        List<ProvedorM> listaProvedor;
        ResultSet rs;
        try {
            this.Conectar();
            String sql = "SELECT * FROM Proveedor";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            rs = ps.executeQuery();
            listaProvedor = new ArrayList();
            ProvedorM provedor;
            while (rs.next()) {
                provedor = new ProvedorM();
                provedor.setNUMPROV(rs.getString("NUMPROV"));
                provedor.setRAZPROV(rs.getString("RAZPROV"));
                provedor.setRUCPROV(rs.getString("RUCPROV"));
                provedor.setDIRPROV(rs.getString("DIRPROV"));
                provedor.setTELFPROV(rs.getString("TELFPROV"));
                provedor.setNUMUBI(rs.getString("NUMUBI"));
                listaProvedor.add(provedor);
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
        return listaProvedor;
    }

    @Override
    public void Registrar(ProvedorM proveedor) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

 

}
