package com.example.Equipo_Futbol.Service;

import com.example.Equipo_Futbol.Model.Equipo;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.Equipo_Futbol.Repositoy.EquipoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipoService {

    @Autowired
    private EquipoRepository equipoRepository;

    public List<Equipo> getAllEquipos() {
        return equipoRepository.findAll();
    }

    public Equipo getEquipoById(Long id) {
        return equipoRepository.findById(id).orElse(null);
    }

    public Equipo saveEquipo(Equipo equipo) {
        return equipoRepository.save(equipo);
    }

    public Equipo updateEquipo(Long id, Equipo equipo) {
        Equipo existing = equipoRepository.findById(id).orElse(null);
        if (existing != null) {
            existing.setNombre(equipo.getNombre());
            existing.setCiudad(equipo.getCiudad());
            existing.setFundacion(equipo.getFundacion());
            return equipoRepository.save(existing);
        }
        return null;
    }

    public void deleteEquipo(Long id) {
        equipoRepository.deleteById(id);
    }
}
