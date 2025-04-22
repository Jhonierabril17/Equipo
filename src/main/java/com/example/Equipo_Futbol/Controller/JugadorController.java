package com.example.Equipo_Futbol.Controller;

import com.example.Equipo_Futbol.Model.Jugador;
import com.example.Equipo_Futbol.Service.JugadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/Jugador")
public class JugadorController {

    @Autowired
    private JugadorService jugadorService;

        @PostMapping
        public ResponseEntity<Jugador> crear(@RequestBody Jugador jugador) {
            return ResponseEntity.ok(jugadorService.saveJugador(jugador));
        }

        @GetMapping
        public ResponseEntity<List<Jugador>> obtenerTodos() {
            return ResponseEntity.ok(jugadorService.getAllJugadores());
        }

        @GetMapping("/{id}")
        public ResponseEntity<Jugador> obtenerPorId(@PathVariable Long id) {
            Jugador jugador = jugadorService.getJugadorById(id);
            return jugador != null ? ResponseEntity.ok(jugador) : ResponseEntity.notFound().build();
        }

        @PutMapping("/{id}")
        public ResponseEntity<Jugador> actualizar(@PathVariable Long id, @RequestBody Jugador jugador) {
            Jugador actualizado = jugadorService.updateJugador(id, jugador);
            return actualizado != null ? ResponseEntity.ok(actualizado) : ResponseEntity.notFound().build();
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> eliminar(@PathVariable Long id) {
            jugadorService.deleteJugador(id);
            return ResponseEntity.noContent().build();
        }
}
