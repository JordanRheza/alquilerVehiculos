package gm.alquilerVehiculos.repository;

import gm.alquilerVehiculos.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}
