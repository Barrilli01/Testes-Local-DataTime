package com.gabrielbarrilli.LocalDataTime.controller;

import com.gabrielbarrilli.LocalDataTime.model.Quarto;
import com.gabrielbarrilli.LocalDataTime.service.QuartoService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/api")
public class QuartoController {

    private final QuartoService quartoService;

    public QuartoController(QuartoService quartoService) {
        this.quartoService = quartoService;
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
