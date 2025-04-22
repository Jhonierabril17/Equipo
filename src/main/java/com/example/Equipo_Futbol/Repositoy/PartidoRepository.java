package com.example.Equipo_Futbol.Repositoy;

import com.example.Equipo_Futbol.Model.Partido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartidoRepository extends JpaRepository<Partido, Long> {
}
