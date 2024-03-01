package com.entities;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
public class Membre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    private String nom;

    private String prenom;

    private String adresse;

    private String mail;

    private String motDePasse;

    private LocalDate dateNaissance;



}
