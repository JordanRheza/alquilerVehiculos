package gm.alquilerVehiculos.repository;

import gm.alquilerVehiculos.models.Tipo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoRepository extends JpaRepository<Tipo, Integer> {
}
