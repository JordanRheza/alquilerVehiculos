package gm.alquilerVehiculos.repository;

import gm.alquilerVehiculos.models.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpleadoRepository extends JpaRepository<Empleado, Integer> {
}
