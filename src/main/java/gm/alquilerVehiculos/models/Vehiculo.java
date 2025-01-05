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
public class Vehiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 10, nullable = false)
    private String placa;

    @OneToMany(mappedBy = "vehiculo")
    private List<Alquiler> alquilers = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "id_tipo", nullable = false)
    private Tipo tipo;
    @ManyToOne
    @JoinColumn(name = "id_marca", nullable = false)
    private Marca marca;
    @ManyToOne
    @JoinColumn(name = "id_estado", nullable = false)
    private Estado estado;
}
