package com.example.Equipo_Futbol.Controller;

import com.example.Equipo_Futbol.Model.Equipo;
import com.example.Equipo_Futbol.Model.Partido;
import com.example.Equipo_Futbol.Service.PartidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/partidos")
public class PartidoController {

        @Autowired
        private PartidoService partidoService;

        @PostMapping("/uno")
        public ResponseEntity<Partido> crear(@RequestBody Partido partido) {
            return ResponseEntity.ok(partidoService.savePartido(partido));
        }

        @PostMapping("/Todos")
        public ResponseEntity<String> guardarPartido(@RequestBody List<Partido> partidos) {
            for (Partido partido : partidos) {
                partidoService.savePartido(partido);
            }
            return ResponseEntity.status(HttpStatus.CREATED).body("Equipos guardados exitosamente.");
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

        @GetMapping("/equipo/{id}/total-goles")
        public ResponseEntity<Integer> totalGolesPorEquipo(@PathVariable("id") Long equipoId) {
            return ResponseEntity.ok(partidoService.totalGolesMarcadosPorEquipo(equipoId));
        }

        @GetMapping("/resultados")
        public ResponseEntity<List<Map<String, Object>>> resultadosPartidos() {
            return ResponseEntity.ok(partidoService.resultadosPartidosConNombres());
        }
 }
