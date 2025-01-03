package gm.alquilerVehiculos.repository;

import gm.alquilerVehiculos.models.Marca;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarcaRepository extends JpaRepository<Marca, Integer> {
}
