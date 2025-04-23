package com.example.Equipo_Futbol.Service;

import com.example.Equipo_Futbol.Model.EstadisticasJugador;
import com.example.Equipo_Futbol.Repository.EstadisticasJugadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstadisticasJugadorService {

    @Autowired
    private EstadisticasJugadorRepository estadisticasjugadorRepository;

    public List<EstadisticasJugador> getAllEstadisticas() {
        return estadisticasjugadorRepository.findAll();
    }

    public EstadisticasJugador getEstadisticaById(Long id) {
        return estadisticasjugadorRepository.findById(id).orElse(null);
    }

    public EstadisticasJugador saveEstadistica(EstadisticasJugador estadistica) {
        return estadisticasjugadorRepository.save(estadistica);
    }

    public EstadisticasJugador updateEstadistica(Long id, EstadisticasJugador estadistica) {
        EstadisticasJugador existing = estadisticasjugadorRepository.findById(id).orElse(null);
        if (existing != null) {
            existing.setJugador(estadistica.getJugador());
            existing.setId_estadistica(estadistica.getId_estadistica());
            existing.setGoles(estadistica.getGoles());
            existing.setAsistencias(estadistica.getAsistencias());
            existing.setTarjetas_amarillas(estadistica.getTarjetas_amarillas());
            existing.setTarjetas_rojas(estadistica.getTarjetas_rojas());
            return estadisticasjugadorRepository.save(existing);
        }
        return null;
    }
    public void eliminarEstadistica (Long id) {
        estadisticasjugadorRepository.deleteById(id);
    }

    public List<EstadisticasJugador> jugadoresConMasDeXGoles(int goles) {
        return estadisticasjugadorRepository.jugadoresConMasDeXGoles(goles);
    }
}
