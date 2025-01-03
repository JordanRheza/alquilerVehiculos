package gm.alquilerVehiculos.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, length = 100)
    private String nombre;
    @Column(nullable = false, length = 100)
    private String email;
    @Column(nullable = false, length = 20)
    private String telefono;
    @Column(nullable = false, length = 20)
    private String usuario;
    @Column(nullable = false, length = 20)
    private String clave;

    @OneToMany(mappedBy = "empleado")
    private List<Alquiler> alquilers = new ArrayList<>();
    @OneToMany(mappedBy = "empleado")
    private List<Pago> pagos = new ArrayList<>();
}
