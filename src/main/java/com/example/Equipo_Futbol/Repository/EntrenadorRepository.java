package com.example.Equipo_Futbol.Repository;

import com.example.Equipo_Futbol.Model.Entrenador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntrenadorRepository extends JpaRepository<Entrenador, Long> {
}
