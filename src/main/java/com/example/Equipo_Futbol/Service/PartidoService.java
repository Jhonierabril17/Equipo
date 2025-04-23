package com.example.Equipo_Futbol.Service;

import com.example.Equipo_Futbol.Model.Partido;
import com.example.Equipo_Futbol.Repository.PartidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartidoService {

    @Autowired
    private PartidoRepository partidoRepository;

    public List<Partido> getAllPartidos() {
        return partidoRepository.findAll();
    }

    public Partido getPartidoById(Long id) {
        return partidoRepository.findById(id).orElse(null);
    }

    public Partido savePartido(Partido partido) {
        return partidoRepository.save(partido);
    }

    public Partido updatePartido(Long id, Partido partido) {
        Partido existing = partidoRepository.findById(id).orElse(null);
        if (existing != null) {
            existing.setFecha(partido.getFecha());
            existing.setEstadio(partido.getEstadio());
            existing.setEquipoLocal(partido.getEquipoLocal());
            existing.setEquipoVisita(partido.getEquipoVisita());
            existing.setGoles_local(partido.getGoles_local());
            existing.setGoles_visita(partido.getGoles_visita());
            return partidoRepository.save(existing);
        }
        return null;
    }

    public void deletePartido(Long id) {
        partidoRepository.deleteById(id);
    }
}
