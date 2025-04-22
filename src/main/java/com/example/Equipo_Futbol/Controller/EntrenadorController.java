package com.example.Equipo_Futbol.Controller;

import com.example.Equipo_Futbol.Model.Entrenador;
import com.example.Equipo_Futbol.Model.Equipo;
import com.example.Equipo_Futbol.Service.EntrenadorService;
import com.example.Equipo_Futbol.Service.EquipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
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
    @PostMapping
    public ResponseEntity<Entrenador> crear(@RequestBody Entrenador entrenador) {
        return ResponseEntity.ok(entrenadorService.saveEntrenador(entrenador));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        entrenadorService.deleteEntrenador(id);
        return ResponseEntity.noContent().build();
    }
}
