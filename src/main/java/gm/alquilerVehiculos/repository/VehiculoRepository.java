package gm.alquilerVehiculos.repository;

import gm.alquilerVehiculos.models.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehiculoRepository extends JpaRepository<Vehiculo, Integer> {
}
