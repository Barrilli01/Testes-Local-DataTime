package com.gabrielbarrilli.LocalDataTime.controller;

import com.gabrielbarrilli.LocalDataTime.model.Quarto;
import com.gabrielbarrilli.LocalDataTime.service.QuartoService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.swing.plaf.SpinnerUI;
import java.util.List;

@Controller
@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/api")
public class QuartoController {

    private final QuartoService quartoService;

    public QuartoController(QuartoService quartoService) {
        this.quartoService = quartoService;
    }

    @GetMapping("/findAllQuartos")
    public List<Quarto> findAllQuartos(){
        return quartoService.findAll();
    }

    @GetMapping("/findQuartoById")
    public Quarto findById(Long id) {
        return quartoService.findById(id);
    }

    @PostMapping("/criarQuarto")
    public Quarto create(Quarto quarto) {
        return quartoService.create(quarto);
    }
}
