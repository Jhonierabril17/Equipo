package com.example.Equipo_Futbol.Service;

import com.example.Equipo_Futbol.Model.Jugador;
import com.example.Equipo_Futbol.Repository.JugadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JugadorService {

        @Autowired
        private JugadorRepository jugadorRepository;

        public List<Jugador> getAllJugadores() {
            return jugadorRepository.findAll();
        }

        public Jugador getJugadorById(Long id) {
            return jugadorRepository.findById(id).orElse(null);
        }

        public Jugador saveJugador(Jugador jugador) {
            return jugadorRepository.save(jugador);
        }

        public Jugador updateJugador(Long id, Jugador jugador) {
            Jugador existing = jugadorRepository.findById(id).orElse(null);
            if (existing != null) {
                existing.setNombre(jugador.getNombre());
                existing.setPosicion(jugador.getPosicion());
                existing.setDorsal(jugador.getDorsal());
                existing.setFecha_nac(jugador.getFecha_nac());
                existing.setNacionalidad(jugador.getNacionalidad());
                existing.setEquipo(jugador.getEquipo());
                return jugadorRepository.save(existing);
            }
            return null;
        }

        public void deleteJugador(Long id) {
            jugadorRepository.deleteById(id);
        }
}
