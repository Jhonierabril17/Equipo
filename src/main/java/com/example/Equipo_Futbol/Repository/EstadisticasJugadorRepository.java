package com.example.Equipo_Futbol.Repository;

import com.example.Equipo_Futbol.Model.EstadisticasJugador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstadisticasJugadorRepository extends JpaRepository<EstadisticasJugador, Long> {
    @Query(value = "SELECT * FROM estadisticas_jugador WHERE goles > :goles", nativeQuery = true)
    List<EstadisticasJugador> jugadoresConMasDeXGoles(@Param("goles") int goles);

}
