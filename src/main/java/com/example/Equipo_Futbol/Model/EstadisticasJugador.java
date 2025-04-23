package com.example.Equipo_Futbol.Model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "Estadisticas_Jugador")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EstadisticasJugador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_estadistica;

    private Integer minutos_jugados;
    private Integer goles;
    private Integer asistencias;
    private Integer tarjetas_amarillas;
    private Integer tarjetas_rojas;

    @ManyToOne
    @JoinColumn(name = "id_jugador")
    private Jugador jugador;

    @ManyToOne
    @JoinColumn(name = "id_partido")
    private Partido partido;
}
