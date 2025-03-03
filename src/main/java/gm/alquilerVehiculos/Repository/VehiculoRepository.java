package gm.alquilerVehiculos.Repository;

import gm.alquilerVehiculos.Models.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehiculoRepository extends JpaRepository<Vehiculo, Integer> {
}
