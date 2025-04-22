package com.example.Equipo_Futbol.Repositoy;

import com.example.Equipo_Futbol.Model.Estadisticas_Jugador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Estadisticos_JugadorRepository extends JpaRepository<Estadisticas_Jugador, Long> {
}
