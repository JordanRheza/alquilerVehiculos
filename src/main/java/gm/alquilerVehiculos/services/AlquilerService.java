package gm.alquilerVehiculos.services;

import gm.alquilerVehiculos.Dto.*;
import gm.alquilerVehiculos.Exception.RecursoNoEncontradoException;
import gm.alquilerVehiculos.models.Alquiler;
import gm.alquilerVehiculos.models.Vehiculo;
import gm.alquilerVehiculos.repository.AlquilerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AlquilerService implements IAlquilerService{

    @Autowired
    private AlquilerRepository alquilerRepository;

    @Override
    public List<AlquilerDTO> listarAlquilers() {
        return this.alquilerRepository.findAll().stream()
                .map(this::convertirAlquilerADTO)
                .collect(Collectors.toList());
    }

    @Override
    public AlquilerDTO buscarAlquilerPorId(Integer id) {
        return this.alquilerRepository.findById(id)
                .map(this::convertirAlquilerADTO)
                .orElseThrow(() -> new RecursoNoEncontradoException("No se encontró un alquiler con el ID: " + id));
    }

    @Override
    public Alquiler guardarAlquiler(Alquiler alquiler) {
        return this.alquilerRepository.save(alquiler);
    }

    @Override
    public void eliminarAlquilerPorId(Integer id) {
        Optional<Alquiler> alquilerOpt = alquilerRepository.findById(id);

        if (alquilerOpt.isPresent()) {
            alquilerRepository.deleteById(id);
        } else {
            throw new RecursoNoEncontradoException("No se encontró un alquiler con el ID: " + id);
        }
    }

    public AlquilerDTO actualizarAlquiler(Integer id, Alquiler alquilerRequest) {
        Optional<Alquiler> alquilerOpt = alquilerRepository.findById(id);

        if (alquilerOpt.isPresent()) {
            Alquiler alquiler = alquilerOpt.get();
            alquiler.setFecha_fin(alquilerRequest.getFecha_fin());
            alquiler.setFecha_inicio(alquilerRequest.getFecha_inicio());
            alquiler.setFecha_entrega(alquilerRequest.getFecha_entrega());
            alquiler.setCosto(alquilerRequest.getCosto());

            Alquiler alquilerActualizado = alquilerRepository.save(alquiler);
            return convertirAlquilerADTO(alquilerActualizado);
        } else {
            throw new RecursoNoEncontradoException("No se encontró un alquiler con el ID: " + id);
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
                alquiler.getEmpleado().getUsuario(),
                alquiler.getEmpleado().getClave()
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
