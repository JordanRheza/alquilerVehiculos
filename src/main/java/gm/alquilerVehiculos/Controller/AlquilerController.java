package gm.alquilerVehiculos.Controller;

import gm.alquilerVehiculos.Dto.AlquilerDTO;
import gm.alquilerVehiculos.Dto.ClienteDTO;
import gm.alquilerVehiculos.Dto.EmpleadoDTO;
import gm.alquilerVehiculos.Dto.VehiculoDTO;
import gm.alquilerVehiculos.models.Alquiler;
import gm.alquilerVehiculos.models.Vehiculo;
import gm.alquilerVehiculos.services.AlquilerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api")
public class AlquilerController {
    @Autowired
    private AlquilerService alquilerService;

    //http://localhost:8080/api/alquilers
    @GetMapping("/alquilers")
    public List<AlquilerDTO> obtenerAlquileres() {
        List<Alquiler> alquilers = alquilerService.listarAlquilers();

        return alquilers.stream().map(alquiler -> {
            Vehiculo vehiculo = alquiler.getVehiculo();
            VehiculoDTO vehiculoDTO = new VehiculoDTO(
                    vehiculo.getId(),
                    vehiculo.getPlaca(),
                    vehiculo.getTipo().getId(),
                    vehiculo.getMarca().getId(),
                    vehiculo.getEstado().getId()
            );

            ClienteDTO clienteDTO = new ClienteDTO(
                    alquiler.getId(), // Supongamos que `getId_cliente()` devuelve una entidad `Cliente`
                    alquiler.getCliente().getNombre(),
                    alquiler.getCliente().getEmail(),
                    alquiler.getCliente().getTelefono()
            );

            EmpleadoDTO empleadoDTO = new EmpleadoDTO(
                    alquiler.getId(), // Supongamos que `getId_empleado()` devuelve una entidad `Empleado`
                    alquiler.getEmpleado().getNombre(),
                    alquiler.getEmpleado().getEmail(),
                    alquiler.getEmpleado().getTelefono(),
                    alquiler.getEmpleado().getUsuario()
            );

            return new AlquilerDTO(
                    alquiler.getId(),
                    alquiler.getFecha_inicio(),
                    alquiler.getFecha_fin(),
                    alquiler.getFecha_entrega(),
                    alquiler.getCosto(),
                    vehiculoDTO,
                    clienteDTO,
                    empleadoDTO
            );
        }).collect(Collectors.toList());
    }
}
