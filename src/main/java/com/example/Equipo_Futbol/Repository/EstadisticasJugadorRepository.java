package com.example.Equipo_Futbol.Repository;

import com.example.Equipo_Futbol.Model.EstadisticasJugador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadisticasJugadorRepository extends JpaRepository<EstadisticasJugador, Long> {
}
