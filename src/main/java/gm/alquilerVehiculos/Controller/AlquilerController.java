package gm.alquilerVehiculos.Controller;

import gm.alquilerVehiculos.Dto.*;
import gm.alquilerVehiculos.Exception.RecursoNoEncontradoException;
import gm.alquilerVehiculos.models.Alquiler;
import gm.alquilerVehiculos.models.Vehiculo;
import gm.alquilerVehiculos.services.AlquilerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api")
public class AlquilerController {
    @Autowired
    private AlquilerService alquilerService;

    //http://localhost:8080/api/alquilers
    @GetMapping("/alquilers")
    public List<AlquilerDTO> obtenerAlquileres() {
        return alquilerService.listarAlquilers().stream()
                .map(this::convertirAlquilerADTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/alquilers/{id}")
    public ResponseEntity<AlquilerDTO> obtenerAlquilerId(@PathVariable int id) {
        Optional<Alquiler> alquilerOpt = Optional.ofNullable(alquilerService.buscarAlquilerPorId(id));

        if (alquilerOpt.isPresent()) {
            AlquilerDTO alquilerDTO = convertirAlquilerADTO(alquilerOpt.get());
            return ResponseEntity.ok(alquilerDTO);
        } else {
            throw new RecursoNoEncontradoException("No se encontro el id:" + id);
        }
    }

    @PutMapping("/alquilers/{id}")
    public ResponseEntity<AlquilerDTO> actualizarAlquiler(@PathVariable int id, @RequestBody Alquiler alquilerResponse) {
        Optional<Alquiler> alquilerOpt = Optional.ofNullable(alquilerService.buscarAlquilerPorId(id));

        if (alquilerOpt.isPresent()) {
            Alquiler alquiler = alquilerOpt.get();
            alquiler.setFecha_fin(alquilerResponse.getFecha_fin());
            alquiler.setFecha_inicio(alquilerResponse.getFecha_entrega());
            alquiler.setFecha_entrega(alquilerResponse.getFecha_entrega());
            alquiler.setCosto(alquilerResponse.getCosto());

            Alquiler actualizado = alquilerService.guardarAlquiler(alquiler);
            AlquilerDTO alquilerDTO = convertirAlquilerADTO(actualizado);

            return ResponseEntity.ok(alquilerDTO);
        } else {
            throw new RecursoNoEncontradoException("No se encontro el id:" + id);
        }
    }

    @PostMapping("/alquiler")
    public Alquiler agregarAlquiler(@RequestBody Alquiler alquiler) {
        return this.alquilerService.guardarAlquiler(alquiler);
    }

    @DeleteMapping("/alquilers/{id}")
    public ResponseEntity<Map<String, Boolean>> eliminarAlquiler(@PathVariable int id) {
        Optional<Alquiler> alquilerOpt = Optional.ofNullable(alquilerService.buscarAlquilerPorId(id));

        if(alquilerOpt.isPresent()) {
            this.alquilerService.eliminarAlquilerPorId((alquilerOpt.get().getId()));
            Map<String, Boolean> res = new HashMap<>();
            res.put("Aquiler eliminado", Boolean.TRUE);
            return ResponseEntity.ok(res);
        }else {
            throw new RecursoNoEncontradoException("No se encontro el id:" + id);
        }
    }

    private AlquilerDTO convertirAlquilerADTO(Alquiler alquiler) {
        VehiculoDTO vehiculoDTO = convertirVehiculoADTO(alquiler.getVehiculo());

        ClienteDTO clienteDTO = new ClienteDTO(
                alquiler.getCliente().getId(),
                alquiler.getCliente().getNombre(),
                alquiler.getCliente().getEmail(),
                alquiler.getCliente().getTelefono()
        );

        EmpleadoDTO empleadoDTO = new EmpleadoDTO(
                alquiler.getEmpleado().getId(),
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
    }

    private VehiculoDTO convertirVehiculoADTO(Vehiculo vehiculo) {
        TipoDTO tipoDTO = new TipoDTO(
                vehiculo.getTipo().getId(),
                vehiculo.getTipo().getDescripcion(),
                vehiculo.getTipo().getDescripcion_ampliada(),
                vehiculo.getTipo().getCosto_alquiler()
        );

        MarcaDTO marcaDTO = new MarcaDTO(
                vehiculo.getMarca().getId(),
                vehiculo.getMarca().getNombre()
        );

        EstadoDTO estadoDTO = new EstadoDTO(
                vehiculo.getEstado().getId(),
                vehiculo.getEstado().getDescripcion()
        );

        return new VehiculoDTO(
                vehiculo.getId(),
                vehiculo.getPlaca(),
                tipoDTO,
                marcaDTO,
                estadoDTO
        );
    }
}
