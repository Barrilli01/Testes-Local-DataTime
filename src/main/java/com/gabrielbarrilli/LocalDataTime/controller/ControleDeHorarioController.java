package com.gabrielbarrilli.LocalDataTime.controller;

import com.gabrielbarrilli.LocalDataTime.model.ControleDeHorario;
import com.gabrielbarrilli.LocalDataTime.service.ControleDeHorarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
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
    public List<ControleDeHorario> findByData(@DateTimeFormat(pattern = "yyyy/MM/dd") LocalDate buscaData){
        return controleDeHorarioService.findByData(buscaData);
    }
    @GetMapping("/findHorarioById/{id}")
    public ControleDeHorario findById(@PathVariable Long id) {
        return controleDeHorarioService.findById(id);
    }

    @PostMapping("/criarHorario/{idQuarto}")
    public ControleDeHorario create(ControleDeHorario controleDeHorario, @PathVariable Long idQuarto) {
        controleDeHorario.setDataEntrada(LocalDate.now());
        return controleDeHorarioService.create(controleDeHorario, idQuarto);
    }

    @PutMapping("/editarSaida/{idControle}")
    public ControleDeHorario editarSaida(@PathVariable Long idControle) {
        return controleDeHorarioService.editarSaida(idControle);
    }

}
