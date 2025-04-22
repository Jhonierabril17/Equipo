package com.example.Equipo_Futbol.Controller;

import com.example.Equipo_Futbol.Model.Estadisticas_Jugador;
import com.example.Equipo_Futbol.Service.Estadisticas_JugadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/Estadisticas")
public class Estadisticas_JugadorController {
/*
    @Autowired
    private Estadisticas_JugadorService estadisticasJugadorService

    @PostMapping
    public ResponseEntity<Estadisticas_Jugador> crear(@RequestBody Estadisticas_Jugador estadistica) {
        return ResponseEntity.ok(estadisticasJugadorService.saveEstadistica(estadistica));
    }

    @GetMapping
    public ResponseEntity<List<Estadisticas_Jugador>> obtenerTodos() {
        return ResponseEntity.ok(estadisticasJugadorService.getAllEstadisticas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Estadisticas_Jugador> obtenerPorId(@PathVariable Long id) {
        Estadisticas_Jugador estadistica = estadisticasJugadorService.getEstadisticaById(id);
        return estadistica != null ? ResponseEntity.ok(estadistica) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Estadisticas_Jugador> actualizar(@PathVariable Long id, @RequestBody Estadisticas_Jugador estadistica) {
        Estadisticas_Jugador actualizado = estadisticasJugadorService.updateEstadistica(id, estadistica);
        return actualizado != null ? ResponseEntity.ok(actualizado) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        estadisticasJugadorService.deleteEstadistica(id);
        return ResponseEntity.noContent().build();
    }

 */
}
