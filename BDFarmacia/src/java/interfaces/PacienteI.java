
package interfaces;

import java.util.List;
import modelo.Paciente;

public interface PacienteI {
    
     void Registrar (Paciente paciente) throws Exception;
     void Modificar (Paciente paciente) throws Exception;
     void Eliminar (Paciente paciente) throws Exception;
     List<Paciente> Lista() throws Exception;     
}
