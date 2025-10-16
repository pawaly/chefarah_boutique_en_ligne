package com.chefarah.chefarah.paniers;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

import com.chefarah.chefarah.utilisateur.Utilisateur;
import com.chefarah.chefarah.produit.Produit;

@Entity
public class Panier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment
    private Long id; // Identifiant unique du panier

    @ManyToOne // Un panier appartient à un utilisateur
    @JoinColumn(name = "utilisateur_id")
    private Utilisateur utilisateur;

    // Un panier peut contenir plusieurs produits
    @ManyToMany 
    @JoinTable(
        name = "panier_produits", // Nom de la table de jointure
        joinColumns = @JoinColumn(name = "panier_id"), // Colonne de jointure pour le panier
        inverseJoinColumns = @JoinColumn(name = "produit_id") // Colonne de jointure pour le produit
    )
    private List<Produit> produits;

    @Column(updatable = false) // La date de création ne peut pas être modifiée
    private LocalDateTime dateCreation = LocalDateTime.now();

    @Column(nullable = false)
    private String etat = "EN_COURS"; // EN_COURS, VALIDE, ANNULE

    // Constructeur vide pour JPA
    public Panier() {}

    // Constructeur complet
    public Panier(Long id, Utilisateur utilisateur, List<Produit> produits, String etat) {
        this.id = id;
        this.utilisateur = utilisateur;
        this.produits = produits;
        this.etat = etat;
        this.dateCreation = LocalDateTime.now();
    }

    // Getters et setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Utilisateur getUtilisateur() { return utilisateur; }
    public void setUtilisateur(Utilisateur utilisateur) { this.utilisateur = utilisateur; }

    public List<Produit> getProduits() { return produits; }
    public void setProduits(List<Produit> produits) { this.produits = produits; }

    public LocalDateTime getDateCreation() { return dateCreation; }
    public void setDateCreation(LocalDateTime dateCreation) { this.dateCreation = dateCreation; }

    public String getEtat() { return etat; }
    public void setEtat(String etat) { this.etat = etat; }
}
