package gm.alquilerVehiculos.Controller;

import gm.alquilerVehiculos.Dto.VehiculoDTO;
import gm.alquilerVehiculos.Models.Vehiculo;
import gm.alquilerVehiculos.Services.VehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api")
public class VehiculoController {
    @Autowired
    private VehiculoService vehiculoService;

    //http://localhost:8080/api/vehiculos
    @GetMapping("/vehiculos")
    public List<VehiculoDTO> obtenerVehiculos() {
        return vehiculoService.listarVehiculos();
    }

    @GetMapping("/vehiculos/{id}")
    public ResponseEntity<VehiculoDTO> obtenerVehiculoId(@PathVariable int id) {
        VehiculoDTO vehiculoDTO = vehiculoService.buscarVehiculoPorId(id);
        return ResponseEntity.ok(vehiculoDTO);
    }

    @PutMapping("/vehiculo/{id}")
    public  ResponseEntity<VehiculoDTO> actualizarVehiculo(@PathVariable int id, @RequestBody Vehiculo vehiculoRequest) {
        VehiculoDTO vehiculoActualizado = vehiculoService.actualizarVehiculo(id, vehiculoRequest);
        return  ResponseEntity.ok(vehiculoActualizado);
    }

    @PostMapping("/vehiculo")
    public Vehiculo agregarVehiculo(@RequestBody Vehiculo vehiculo) {
        return this.vehiculoService.guardarVehiculo(vehiculo);
    }

    @DeleteMapping("/vehiculo/{id}")
    public ResponseEntity<Map<String, Boolean>> eliminarVehiculo(@PathVariable int id) {
        vehiculoService.eliminarVehiculoPorId(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Vehiculo eliminado", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
