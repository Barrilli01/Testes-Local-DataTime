package com.gabrielbarrilli.LocalDataTime.controller;

import com.gabrielbarrilli.LocalDataTime.model.ControleDeHorario;
import com.gabrielbarrilli.LocalDataTime.service.ControleDeHorarioService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/api")
public class ControleDeHorarioController {

    @Autowired
    private final ControleDeHorarioService controleDeHorarioService;

    public ControleDeHorarioController(ControleDeHorarioService controleDeHorarioService) {
        this.controleDeHorarioService = controleDeHorarioService;
    }

    @GetMapping("/buscaPorDataAtual")
    public List<ControleDeHorario> Teste (){
        return controleDeHorarioService.Teste();
    }
    @GetMapping("/findHorarioById/{id}")
    public ControleDeHorario findById(@PathVariable Long id) {
        return controleDeHorarioService.findById(id);
    }

    @PostMapping("/criarHorario/{idQuarto}")
    public ControleDeHorario create(ControleDeHorario controleDeHorario, @PathVariable Long idQuarto) {
        controleDeHorario.setDataHoraAtual(LocalDateTime.now());
        return controleDeHorarioService.create(controleDeHorario, idQuarto);
    }

    @PutMapping("/editarHorarioSaida/{idControle}")
    public ControleDeHorario editarHorarioSaida(@PathVariable Long idControle) {
        return controleDeHorarioService.editarHorarioSaida(idControle);
    }

}
