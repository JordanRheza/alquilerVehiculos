package gm.alquilerVehiculos.repository;

import gm.alquilerVehiculos.models.Alquiler;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlquilerRepository extends JpaRepository<Alquiler, Integer> {
}
