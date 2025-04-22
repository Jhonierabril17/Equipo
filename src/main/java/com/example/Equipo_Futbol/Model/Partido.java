package com.example.Equipo_Futbol.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Partido")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Partido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_partido;

    private Date fecha;
    private String estadio;

    @ManyToOne
    @JoinColumn(name = "equipo_local")
    private Equipo equipoLocal;

    @ManyToOne
    @JoinColumn(name = "equipo_visita")
    private Equipo equipoVisita;

    private Integer goles_local;
    private Integer goles_visita;

    @OneToMany(mappedBy = "partido", cascade = CascadeType.ALL)
    private List<Estadisticas_Jugador> estadisticas;
}
