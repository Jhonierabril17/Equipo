package com.example.Equipo_Futbol.Controller;

import com.example.Equipo_Futbol.Model.Partido;
import com.example.Equipo_Futbol.Service.PartidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/partidos")
public class PartidoController {

        @Autowired
        private PartidoService partidoService;

        @PostMapping
        public ResponseEntity<Partido> crear(@RequestBody Partido partido) {
            return ResponseEntity.ok(partidoService.savePartido(partido));
        }

        @GetMapping
        public ResponseEntity<List<Partido>> obtenerTodos() {
            return ResponseEntity.ok(partidoService.getAllPartidos());
        }

        @GetMapping("/{id}")
        public ResponseEntity<Partido> obtenerPorId(@PathVariable Long id) {
            Partido partido = partidoService.getPartidoById(id);
            return partido != null ? ResponseEntity.ok(partido) : ResponseEntity.notFound().build();
        }

        @PutMapping("/{id}")
        public ResponseEntity<Partido> actualizar(@PathVariable Long id, @RequestBody Partido partido) {
            Partido actualizado = partidoService.updatePartido(id, partido);
            return actualizado != null ? ResponseEntity.ok(actualizado) : ResponseEntity.notFound().build();
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> eliminar(@PathVariable Long id) {
            partidoService.deletePartido(id);
            return ResponseEntity.noContent().build();
        }
 }
