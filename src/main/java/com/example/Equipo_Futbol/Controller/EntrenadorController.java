package com.example.Equipo_Futbol.Controller;

import com.example.Equipo_Futbol.Model.Entrenador;
import com.example.Equipo_Futbol.Model.Equipo;
import com.example.Equipo_Futbol.Service.EntrenadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Entrenador")
public class EntrenadorController {

    @Autowired
    private EntrenadorService entrenadorService;

    @GetMapping
    public ResponseEntity<List<Entrenador>> buscarTodos() {
        return ResponseEntity.ok(entrenadorService.getAllEntrenadores());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Entrenador> buscarPorId(@PathVariable Long id) {
        Entrenador entrenador = entrenadorService.getEntrenadorById(id);
        return entrenador != null ? ResponseEntity.ok(entrenador) : ResponseEntity.notFound().build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<Entrenador> actualizar(@PathVariable Long id, @RequestBody Entrenador entrenador) {
        Entrenador actualizado = entrenadorService.updateEntrenador(id, entrenador);
        return actualizado != null ? ResponseEntity.ok(actualizado) : ResponseEntity.notFound().build();
    }
    @PostMapping("/Uno")
    public ResponseEntity<Entrenador> crear(@RequestBody Entrenador entrenador) {
        return ResponseEntity.ok(entrenadorService.saveEntrenador(entrenador));
    }

    @PostMapping("/Todos")
    public ResponseEntity<String> guardarEntrenador(@RequestBody List<Entrenador> entrenadores) {
        for (Entrenador entrenador : entrenadores) {
            entrenadorService.saveEntrenador(entrenador);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body("Entrenadores guardados exitosamente.");
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        entrenadorService.deleteEntrenador(id);
        return ResponseEntity.noContent().build();
    }
}
