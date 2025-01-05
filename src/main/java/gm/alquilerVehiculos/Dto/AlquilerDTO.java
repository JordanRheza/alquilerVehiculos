package gm.alquilerVehiculos.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlquilerDTO {
    private Integer id;
    private Date fecha_inicio;
    private Date fecha_fin;
    private Date fecha_entrega;
    private Double costo;
    private VehiculoDTO vehiculo; // Información del vehículo
    private ClienteDTO cliente;  // Información del cliente
    private EmpleadoDTO empleado; // Información del empleado
}
