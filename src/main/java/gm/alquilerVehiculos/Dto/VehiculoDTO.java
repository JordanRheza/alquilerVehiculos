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
    private Integer id_tipo;   // Solo el ID del tipo
    private Integer id_marca;  // Solo el ID de la marca
    private Integer id_estado; // Solo el ID del estado
}
