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
public class Tipo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, length = 20)
    private String descripcion;
    @Column(nullable = false)
    private String descripcion_ampliada;
    @Column(nullable = false, length = 10)
    private Double costo_alquiler;
    @OneToMany(mappedBy = "tipo")
    private List<Vehiculo> vehiculos = new ArrayList<>();

}
