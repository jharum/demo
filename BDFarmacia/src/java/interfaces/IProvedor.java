package interfaces;

import java.util.List;
import modelo.ProvedorM;

public interface IProvedor {

    void Registrar(ProvedorM proveedor) throws Exception;

    void Modificar(ProvedorM proveedor) throws Exception;

    void Eliminar(ProvedorM proveedor) throws Exception;

    List<ProvedorM> listar() throws Exception;

}
