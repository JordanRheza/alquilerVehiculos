package gm.alquilerVehiculos.Services;

import gm.alquilerVehiculos.Dto.EstadoDTO;
import gm.alquilerVehiculos.Dto.MarcaDTO;
import gm.alquilerVehiculos.Dto.TipoDTO;
import gm.alquilerVehiculos.Dto.VehiculoDTO;
import gm.alquilerVehiculos.Exception.RecursoNoEncontradoException;
import gm.alquilerVehiculos.Models.Marca;
import gm.alquilerVehiculos.Models.Tipo;
import gm.alquilerVehiculos.Models.Vehiculo;
import gm.alquilerVehiculos.Repository.VehiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VehiculoService implements IVehiculoService{

    @Autowired
    private VehiculoRepository vehiculoRepository;

    @Override
    public List<VehiculoDTO> listarVehiculos() {
        return this.vehiculoRepository.findAll().stream()
                .map(this::convertirVehiculoADTO)
                .collect(Collectors.toList());
    }

    @Override
    public VehiculoDTO buscarVehiculoPorId(Integer id) {
        return this.vehiculoRepository.findById(id)
                .map(this::convertirVehiculoADTO)
                .orElseThrow(() -> new RecursoNoEncontradoException("No se encontro el vehiculo con ID: " + id));
    }

    @Override
    public Vehiculo guardarVehiculo(Vehiculo vehiculo) {
        return this.vehiculoRepository.save(vehiculo);
    }

    @Override
    public void eliminarVehiculoPorId(Integer id) {
        Optional<Vehiculo> vehiculoOpt = vehiculoRepository.findById(id);
        if (vehiculoOpt.isPresent()) {
            vehiculoRepository.deleteById(id);
        } else {
            throw new RecursoNoEncontradoException("No se encontró un alquiler con el ID: " + id);
        }
    }

    public  VehiculoDTO actualizarVehiculo (Integer id, Vehiculo vehiculoResquest) {
        Optional<Vehiculo> vehiculoOpt = vehiculoRepository.findById(id);

        if(vehiculoOpt.isPresent()) {
            Vehiculo vehiculo = vehiculoOpt.get();
            vehiculo.setPlaca(vehiculoResquest.getPlaca());

            Vehiculo vehiculoActualizado = vehiculoRepository.save(vehiculo);
            return convertirVehiculoADTO(vehiculoActualizado);
        } else {
            throw  new RecursoNoEncontradoException("No se encontro el vehiculo con ID: " + id);
        }
    }

    //Convertir los Modelos a DTO
    private VehiculoDTO convertirVehiculoADTO(Vehiculo vehiculo) {
        MarcaDTO marcaDTO = new MarcaDTO(
                vehiculo.getMarca().getId(),
                vehiculo.getMarca().getNombre()
        );

        TipoDTO tipoDTO = new TipoDTO(
                vehiculo.getTipo().getId(),
                vehiculo.getTipo().getDescripcion(),
                vehiculo.getTipo().getDescripcion_ampliada(),
                vehiculo.getTipo().getCosto_alquiler()
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
