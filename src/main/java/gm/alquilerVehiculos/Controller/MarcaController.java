package gm.alquilerVehiculos.Controller;

import gm.alquilerVehiculos.AlquilerVehiculosApplication;
import gm.alquilerVehiculos.Dto.MarcaDTO;
import gm.alquilerVehiculos.Models.Marca;
import gm.alquilerVehiculos.Services.MarcaService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("api")
public class MarcaController {
    private static final Logger logger = LogManager.getLogger(AlquilerVehiculosApplication.class);

    @Autowired
    private MarcaService marcaService;

    //http://localhost:8080/api/marcas
    @GetMapping("/marcas")
    public List<MarcaDTO> obtenerMarcas() {
        logger.info(marcaService);
        return marcaService.listarMarcas();
    }

    @GetMapping("/marca/{id}")
    public ResponseEntity<MarcaDTO> obtenerMarcaId(@PathVariable int id) {
        MarcaDTO marcaDTO = marcaService.buscarMarcaId(id);
        return ResponseEntity.ok(marcaDTO);
    }

    @PutMapping("marca/{id}")
    public ResponseEntity<MarcaDTO> actualizarAlquiler(@PathVariable int id, @RequestBody Marca marcaRequest) {
        MarcaDTO marcaActualizado = marcaService.actualizarMarca(id, marcaRequest);
        return ResponseEntity.ok(marcaActualizado);
    }

    @PostMapping("/marca")
    public Marca agregarMarca(@RequestBody Marca marca) {
        return  this.marcaService.guardarMarca(marca);
    }

    @DeleteMapping("/marca/{id}")
    public ResponseEntity<Map<String, Boolean>> eliminarAlquiler(@PathVariable int id) {
        marcaService.eliminarMarcaPorId(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Marca eliminado", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

}
