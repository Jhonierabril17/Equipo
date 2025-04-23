package com.example.Equipo_Futbol.Repository;

import com.example.Equipo_Futbol.Model.Partido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface PartidoRepository extends JpaRepository<Partido, Long> {

    @Query(value = """
    SELECT SUM(CASE\s
                 WHEN p.equipo_local = :id_equipo THEN p.goles_local\s
                 WHEN p.equipo_visita= :id_equipo THEN p.goles_visita\s
                 ELSE 0\s
               END)
    FROM partido p
""", nativeQuery = true)
    Integer totalGolesMarcadosPorEquipo(@Param("id_equipo") Long id_equipo);

    @Query(value = """
    SELECT 
        p.id_partido AS id_partido,
        el.nombre AS equipo_local,
        ev.nombre AS equipo_visita,
        p.goles_local,
        p.goles_visita
    FROM partido p
    JOIN equipo el ON p.equipo_local = el.id_equipo
    JOIN equipo ev ON p.equipo_visita= ev.id_equipo
""", nativeQuery = true)
    List<Map<String, Object>> resultadosPartidosConNombres();

}
