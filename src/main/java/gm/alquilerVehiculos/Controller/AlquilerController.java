package gm.alquilerVehiculos.Controller;

import gm.alquilerVehiculos.Dto.*;
import gm.alquilerVehiculos.models.Alquiler;
import gm.alquilerVehiculos.services.AlquilerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api")
public class AlquilerController {
    @Autowired
    private AlquilerService alquilerService;

    //http://localhost:8080/api/alquilers
    @GetMapping("/alquilers")
    public List<AlquilerDTO> obtenerAlquileres() {
        return alquilerService.listarAlquilers();
    }

    @GetMapping("/alquilers/{id}")
    public ResponseEntity<AlquilerDTO> obtenerAlquilerId(@PathVariable int id) {
        AlquilerDTO alquilerDTO = alquilerService.buscarAlquilerPorId(id);
        return ResponseEntity.ok(alquilerDTO);
    }

    @PutMapping("/alquilers/{id}")
    public ResponseEntity<AlquilerDTO> actualizarAlquiler(@PathVariable int id, @RequestBody Alquiler alquilerRequest) {
        AlquilerDTO alquilerActualizado = alquilerService.actualizarAlquiler(id, alquilerRequest);
        return ResponseEntity.ok(alquilerActualizado);
    }

    @PostMapping("/alquiler")
    public Alquiler agregarAlquiler(@RequestBody Alquiler alquiler) {
        return this.alquilerService.guardarAlquiler(alquiler);
    }

    @DeleteMapping("/alquilers/{id}")
    public ResponseEntity<Map<String, Boolean>> eliminarAlquiler(@PathVariable int id) {
        alquilerService.eliminarAlquilerPorId(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Alquiler eliminado", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }



}
