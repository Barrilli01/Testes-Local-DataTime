package com.gabrielbarrilli.LocalDataTime.controller;

import com.gabrielbarrilli.LocalDataTime.model.ControleDeHorario;
import com.gabrielbarrilli.LocalDataTime.response.ControleDeHorarioResponse;
import com.gabrielbarrilli.LocalDataTime.service.ControleDeHorarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
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

    @GetMapping("/findAllRegistros")
    public List<ControleDeHorario> findAll(){
        return controleDeHorarioService.findAll();
    }

    @GetMapping("/buscaPorDataDigitada")
    public List<ControleDeHorario> findByData(LocalDate buscaData){
        return controleDeHorarioService.findByData(buscaData);
    }

    @GetMapping("/findHorarioById/{id}")
    public ControleDeHorarioResponse findById(@PathVariable Long id) {
        return controleDeHorarioService.findById(id);
    }

    @PostMapping("/criarHorario/{idQuarto}")
    public ControleDeHorario create(ControleDeHorario controleDeHorario, @PathVariable Long idQuarto) {
        return controleDeHorarioService.create(controleDeHorario, idQuarto);
    }

    @PutMapping("/editarSaida/{idControle}")
    public ControleDeHorario editarSaida(@PathVariable Long idControle) {
        return controleDeHorarioService.editarSaida(idControle);
    }

}
