package com.example.Equipo_Futbol.Repository;

import com.example.Equipo_Futbol.Model.Jugador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JugadorRepository extends JpaRepository<Jugador, Long> {
    @Query(value = "SELECT * FROM jugador WHERE id_equipo = :id_equipo", nativeQuery = true)
    List<Jugador> obtenerJugadoresPorEquipo(@Param("id_equipo") Long id_equipo);
}
