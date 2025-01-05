package gm.alquilerVehiculos.Dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehiculoDTO {
    private Integer id;
    private String placa;
    private TipoDTO tipo;
    private MarcaDTO marca;
    private EstadoDTO estado;
}
