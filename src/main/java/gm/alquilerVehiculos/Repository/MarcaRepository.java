package gm.alquilerVehiculos.Repository;

import gm.alquilerVehiculos.Models.Marca;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarcaRepository extends JpaRepository<Marca, Integer> {
}
