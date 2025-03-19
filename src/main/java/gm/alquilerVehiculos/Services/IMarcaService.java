package gm.alquilerVehiculos.Services;

import gm.alquilerVehiculos.Dto.MarcaDTO;
import gm.alquilerVehiculos.Models.Marca;

import java.util.List;

public interface IMarcaService {
    public List<MarcaDTO> listarMarcas();

    public MarcaDTO buscarMarcaId(Integer id);

    public Marca guardarMarca(Marca marca);

    public void eliminarMarcaPorId(Integer id);
}
