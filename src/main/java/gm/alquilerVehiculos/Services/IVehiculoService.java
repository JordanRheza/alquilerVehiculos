package gm.alquilerVehiculos.Services;



import gm.alquilerVehiculos.Dto.VehiculoDTO;
import gm.alquilerVehiculos.Models.Vehiculo;

import java.util.List;

public interface IVehiculoService {
    public List<VehiculoDTO> listarVehiculos();

    public VehiculoDTO buscarVehiculoPorId(Integer id);

    public Vehiculo guardarVehiculo(Vehiculo vehiculo);

    public void eliminarVehiculoPorId(Integer id);
}
