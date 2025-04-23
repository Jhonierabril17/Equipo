package com.example.Equipo_Futbol.Repository;

import com.example.Equipo_Futbol.Model.Jugador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JugadorRepository extends JpaRepository<Jugador, Long> {
}
