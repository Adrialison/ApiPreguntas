/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.APIpreguntas.repository;

import com.example.APIpreguntas.model.PreguntaFrecuente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PreguntaFrecuenteRepository extends JpaRepository<PreguntaFrecuente, Integer>{
    
}
