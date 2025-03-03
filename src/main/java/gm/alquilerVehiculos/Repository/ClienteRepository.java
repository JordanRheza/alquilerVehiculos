package gm.alquilerVehiculos.Repository;

import gm.alquilerVehiculos.Models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}
