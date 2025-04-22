package com.example.Equipo_Futbol.Service;

import com.example.Equipo_Futbol.Model.Entrenador;
import com.example.Equipo_Futbol.Model.Equipo;
import com.example.Equipo_Futbol.Repositoy.EntrenadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntrenadorService {

    @Autowired
    private EntrenadorRepository entrenadorRepository;

    public List<Entrenador> getAllEntrenadores() {
        return entrenadorRepository.findAll();
    }

    public Entrenador getEntrenadorById(Long id) {
        return entrenadorRepository.findById(id).orElse(null);
    }

    public Entrenador saveEntrenador(Entrenador entrenador) {
        return entrenadorRepository.save(entrenador);
    }

    public Entrenador updateEntrenador(Long id, Entrenador entrenador) {
        Entrenador existing = entrenadorRepository.findById(id).orElse(null);
        if (existing != null) {
            existing.setNombre(entrenador.getNombre());
            existing.setEspecialidad(entrenador.getEspecialidad());
            existing.setEquipo(entrenador.getEquipo());
            return entrenadorRepository.save(existing);
        }
        return null;
    }

    public void deleteEntrenador(Long id) {
        entrenadorRepository.deleteById(id);
    }
}
