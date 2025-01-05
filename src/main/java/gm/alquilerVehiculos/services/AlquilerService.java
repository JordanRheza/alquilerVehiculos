package gm.alquilerVehiculos.services;

import gm.alquilerVehiculos.models.Alquiler;
import gm.alquilerVehiculos.repository.AlquilerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlquilerService implements IAlquilerService{

    @Autowired
    private AlquilerRepository alquilerRepository;


    @Override
    public List<Alquiler> listarAlquilers() {
        return this.alquilerRepository.findAll();
    }

    @Override
    public Alquiler buscarAlquilerPorId(Integer id) {
        Alquiler alquiler = this.alquilerRepository.findById(id).orElse(null);
        return alquiler;
    }

    @Override
    public Alquiler guardarAlquiler(Alquiler alquiler) {
        return this.alquilerRepository.save(alquiler);
    }

    @Override
    public void eliminarAlquilerPorId(Integer id) {
        this.alquilerRepository.deleteById(id);
    }
}
