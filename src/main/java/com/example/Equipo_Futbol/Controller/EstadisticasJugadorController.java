package com.example.Equipo_Futbol.Controller;

import com.example.Equipo_Futbol.Model.EstadisticasJugador;
import com.example.Equipo_Futbol.Service.EstadisticasJugadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/Estadisticas")
public class EstadisticasJugadorController {

    @Autowired
    private EstadisticasJugadorService estadisticasJugadorService;

    @PostMapping
    public ResponseEntity<EstadisticasJugador> crear(@RequestBody EstadisticasJugador estadistica) {
        return ResponseEntity.ok(estadisticasJugadorService.saveEstadistica(estadistica));
    }

    @GetMapping
    public ResponseEntity<List<EstadisticasJugador>> obtenerTodos() {
        return ResponseEntity.ok(estadisticasJugadorService.getAllEstadisticas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EstadisticasJugador> obtenerPorId(@PathVariable Long id) {
        EstadisticasJugador estadistica = estadisticasJugadorService.getEstadisticaById(id);
        return ResponseEntity.ok(estadistica);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EstadisticasJugador> actualizar(@PathVariable Long id, @RequestBody EstadisticasJugador estadistica) {
        EstadisticasJugador actualizado = estadisticasJugadorService.updateEstadistica(id, estadistica);
        return actualizado != null ? ResponseEntity.ok(actualizado) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        estadisticasJugadorService.eliminarEstadistica(id);
        return ResponseEntity.noContent().build();
    }
}
