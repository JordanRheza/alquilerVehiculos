package gm.alquilerVehiculos.services;

import gm.alquilerVehiculos.models.Alquiler;

import java.util.List;

public interface IAlquilerService {
    public List<Alquiler> listarAlquilers();

    public Alquiler buscarAlquilerPorId(Integer id);

    public Alquiler guardarAlquiler(Alquiler alquiler);

    public void eliminarAlquilerPorId(Integer id);
}
