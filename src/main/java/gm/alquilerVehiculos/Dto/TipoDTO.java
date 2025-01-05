package gm.alquilerVehiculos.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TipoDTO {
    private Integer id;
    private String descripcion;
    private String descripcion_ampliada;
    private Double costo_alquiler;
}
