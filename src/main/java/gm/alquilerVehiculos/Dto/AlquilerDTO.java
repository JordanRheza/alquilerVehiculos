package gm.alquilerVehiculos.Dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlquilerDTO {
    private Integer id;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "America/Guayaquil")
    private Date fecha_inicio;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "America/Guayaquil")
    private Date fecha_fin;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "America/Guayaquil")
    private Date fecha_entrega;
    private Double costo;
    private VehiculoDTO vehiculo; // Información del vehículo
    private ClienteDTO cliente;  // Información del cliente
    private EmpleadoDTO empleado; // Información del empleado
}
