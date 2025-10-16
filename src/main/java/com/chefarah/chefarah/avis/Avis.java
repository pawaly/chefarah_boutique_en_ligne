package com.chefarah.chefarah.avis;

import jakarta.persistence.*;
import java.time.LocalDateTime;

import com.chefarah.chefarah.produit.Produit;
import com.chefarah.chefarah.utilisateur.Utilisateur;

@Entity
public class Avis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Identifiant unique de l'avis

    @ManyToOne //
    @JoinColumn(name = "utilisateur_id", nullable = false)
    private Utilisateur utilisateur; // Utilisateur qui laisse l'avis

    @ManyToOne
    @JoinColumn(name = "produit_id", nullable = false)
    private Produit produit; // Produit sur lequel l'avis est laissé

    @Column(nullable = false)
    private int note; // Note donnée au produit, ex: 1 à 5

    @Lob
    @Column(nullable = false)
    private String commentaire; // Commentaire optionnel

    @Column(updatable = false)
    private LocalDateTime dateCreation = LocalDateTime.now(); // Date de création de l'avis

    // Constructeur vide pour JPA
    public Avis() {}

    // Constructeur complet
    public Avis(Long id, Utilisateur utilisateur, Produit produit, int note, String commentaire) {
        this.id = id;
        this.utilisateur = utilisateur;
        this.produit = produit;
        this.note = note;
        this.commentaire = commentaire;
        this.dateCreation = LocalDateTime.now();
    }

    // Getters et setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Utilisateur getUtilisateur() { return utilisateur; }
    public void setUtilisateur(Utilisateur utilisateur) { this.utilisateur = utilisateur; }

    public Produit getProduit() { return produit; }
    public void setProduit(Produit produit) { this.produit = produit; }

    public int getNote() { return note; }
    public void setNote(int note) { this.note = note; }

    public String getCommentaire() { return commentaire; }
    public void setCommentaire(String commentaire) { this.commentaire = commentaire; }

    public LocalDateTime getDateCreation() { return dateCreation; }
    public void setDateCreation(LocalDateTime dateCreation) { this.dateCreation = dateCreation; }
}
