package gm.alquilerVehiculos.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmpleadoDTO {
    private Integer id;
    private String nombre;
    private String email;
    private String telefono;
    private String usuario;
    private String clave;
}
