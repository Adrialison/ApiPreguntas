/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.APIpreguntas.service;

import org.springframework.stereotype.Service;
import com.example.APIpreguntas.model.PreguntaFrecuente;
import com.example.APIpreguntas.repository.PreguntaFrecuenteRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


@Service
public class PreguntaFrecuenteService {
    
       @Autowired
    private PreguntaFrecuenteRepository repository;

    public List<PreguntaFrecuente> findAll() {
        return repository.findAll();
    }

    public PreguntaFrecuente save(PreguntaFrecuente preguntaFrecuente) {
        return repository.save(preguntaFrecuente);
    }

    public void deleteById(int id) {
        repository.deleteById(id);
    }

    public PreguntaFrecuente findById(int id) {
        return repository.findById(id).orElse(null);
    }
}
