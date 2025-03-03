package gm.alquilerVehiculos.Repository;

import gm.alquilerVehiculos.Models.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpleadoRepository extends JpaRepository<Empleado, Integer> {
}
