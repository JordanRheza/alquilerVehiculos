package gm.alquilerVehiculos.Services;

import gm.alquilerVehiculos.Dto.AlquilerDTO;
import gm.alquilerVehiculos.Models.Alquiler;

import java.util.List;

public interface IAlquilerService {
    public List<AlquilerDTO> listarAlquilers();

    public AlquilerDTO buscarAlquilerPorId(Integer id);

    public Alquiler guardarAlquiler(Alquiler alquiler);

    public void eliminarAlquilerPorId(Integer id);
}
