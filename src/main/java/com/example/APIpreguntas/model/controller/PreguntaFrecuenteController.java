package com.example.APIpreguntas.model.controller;

import com.example.APIpreguntas.model.PreguntaFrecuente;
import com.example.APIpreguntas.service.PreguntaFrecuenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/api/preguntas")
public class PreguntaFrecuenteController {

    @Autowired
    private PreguntaFrecuenteService service;

    @GetMapping
    public List<PreguntaFrecuente> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PreguntaFrecuente> getPreguntaById(@PathVariable int id) {
        PreguntaFrecuente pregunta = service.findById(id);
        if (pregunta != null) {
            return ResponseEntity.ok(pregunta);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<PreguntaFrecuente> createPregunta(@RequestBody PreguntaFrecuente pregunta) {
        try {
            PreguntaFrecuente nuevaPregunta = service.save(pregunta);
            return ResponseEntity.ok(nuevaPregunta);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<PreguntaFrecuente> updatePregunta(@PathVariable int id, @RequestBody PreguntaFrecuente pregunta) {
        PreguntaFrecuente existente = service.findById(id);
        if (existente != null) {
            existente.setPregunta(pregunta.getPregunta());
            existente.setRespuesta(pregunta.getRespuesta());
            service.save(existente);
            return ResponseEntity.ok(existente);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePregunta(@PathVariable int id) {
        try {
            service.deleteById(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

}
