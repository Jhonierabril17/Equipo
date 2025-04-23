package com.example.Equipo_Futbol.Controller;

import com.example.Equipo_Futbol.Model.Equipo;
import com.example.Equipo_Futbol.Service.EquipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Equipo")
public class EquipoController {

    @Autowired
    private EquipoService equipoService;

        @GetMapping
        public ResponseEntity<List<Equipo>> BuscarTodos() {
            return ResponseEntity.ok(equipoService.getAllEquipos());
        }

        @GetMapping("/{id}")
        public ResponseEntity<Equipo> BuscarPorId(@PathVariable Long id) {
            Equipo equipo = equipoService.getEquipoById(id);
            return equipo != null ? ResponseEntity.ok(equipo) : ResponseEntity.notFound().build();
        }

        @PutMapping("/{id}")
        public ResponseEntity<Equipo> actualizar(@PathVariable Long id, @RequestBody Equipo equipo) {
            Equipo actualizado = equipoService.updateEquipo(id, equipo);
            return actualizado != null ? ResponseEntity.ok(actualizado) : ResponseEntity.notFound().build();
        }

        @PostMapping("/Uno")
        public ResponseEntity<Equipo> crear(@RequestBody Equipo equipo) {
            return ResponseEntity.ok(equipoService.saveEquipo(equipo));
        }

        @PostMapping("/Todos")
        public ResponseEntity<String> guardarEquipos(@RequestBody List<Equipo> equipos) {
            for (Equipo equipo : equipos) {
                equipoService.saveEquipo(equipo);
            }
            return ResponseEntity.status(HttpStatus.CREATED).body("Equipos guardados exitosamente.");
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> eliminar(@PathVariable Long id) {
            equipoService.deleteEquipo(id);
            return ResponseEntity.noContent().build();
        }
}
