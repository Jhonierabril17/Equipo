package com.example.Equipo_Futbol.Service;

import com.example.Equipo_Futbol.Repositoy.Estadisticos_JugadorRepository;
import com.example.Equipo_Futbol.Repositoy.Estadisticos_JugadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Estadisticas_JugadorService {
/*
    @Autowired
    private Estadisticos_JugadorRepository estadisticas_jugadorRepository;

    public List<Estadisticos_JugadorRepository> getAllEstadisticas() {
        return estadisticas_jugadorRepository.findAll();
    }

    public Estadisticos_JugadorRepository getEstadisticaById(Long id) {
        return estadisticas_jugadorRepository.findById(id).orElse(null);
    }

    public Estadisticos_JugadorRepository saveEstadistica(Estadisticos_JugadorRepository estadistica) {
        return estadisticasJugadorRepository.save(estadistica);
    }

    public Estadísticos_JugadorRepository updateEstadistica(Long id, Estadísticos_JugadorRepository estadistica) {
        Estadísticos_JugadorRepository existing = (Estadísticos_JugadorRepository) estadisticasJugadorRepository.findById(id).orElse(null);
        if (existing != null) {
            existing.setJugador(estadistica.getJugador());
            existing.setId_partido(estadistica.getId_partido());
            existing.setMinutos_jugados(estadistica.getMinutos_jugados());
            existing.setGoles(estadistica.getGoles());
            existing.setAsistencias(estadistica.getAsistencias());
            existing.setTarjetas_amarillas(estadistica.getTarjetas_amarillas());
            existing.setTarjetas_rojas(estadistica.getTarjetas_rojas());
            return estadisticasJugadorRepository.save(existing);
        }
        return null;
    }

    public void deleteEstadistica(Long id) {
        estadisticasJugadorRepository.deleteById(id);
    }

 */
}
