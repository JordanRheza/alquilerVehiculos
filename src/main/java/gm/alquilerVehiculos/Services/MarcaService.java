package gm.alquilerVehiculos.Services;

import gm.alquilerVehiculos.Dto.MarcaDTO;
import gm.alquilerVehiculos.Exception.RecursoNoEncontradoException;
import gm.alquilerVehiculos.Models.Marca;
import gm.alquilerVehiculos.Repository.MarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MarcaService implements IMarcaService{

    @Autowired
    MarcaRepository marcaRepository;

    @Override
    public List<MarcaDTO> listarMarcas() {
        return this.marcaRepository.findAll().stream()
                .map(this::convertirMarcaADTO)
                .collect(Collectors.toList());
    }

    @Override
    public MarcaDTO buscarMarcaId(Integer id) {
        return this.marcaRepository.findById(id)
                .map(this::convertirMarcaADTO)
                .orElseThrow(() -> new RecursoNoEncontradoException("No se encontro una marca con el ID: " + id));
    }

    @Override
    public Marca guardarMarca(Marca marca) {
        return this.marcaRepository.save(marca);
    }

    @Override
    public void eliminarMarcaPorId(Integer id) {
        Optional<Marca> marcaOpt = marcaRepository.findById(id);

        if (marcaOpt.isPresent()) {
            marcaRepository.deleteById(id);
        } else {
            throw new RecursoNoEncontradoException("No se encontró una marca con el ID: " + id);
        }
    }

    public MarcaDTO actualizarMarca(Integer id, Marca marcarRequest) {
        Optional<Marca> marcaOpt = marcaRepository.findById(id);

        if (marcaOpt.isPresent()) {
            Marca marca = marcaOpt.get();
            marca.setNombre(marcarRequest.getNombre());

            Marca marcaActualizado = marcaRepository.save(marca);
            return convertirMarcaADTO(marcaActualizado);
        } else {
            throw new RecursoNoEncontradoException("No se encontro una marca con el ID: " + id);
        }

    }

    //Covertir Modelo a DTO
    private MarcaDTO convertirMarcaADTO(Marca marca) {
        return new MarcaDTO(
                marca.getId(),
                marca.getNombre()
        );
    }
}
