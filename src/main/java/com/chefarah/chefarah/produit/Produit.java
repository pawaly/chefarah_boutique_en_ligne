package com.chefarah.chefarah.produit;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import com.chefarah.chefarah.categories.Categories;
import com.chefarah.chefarah.images_produits.Image;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity

public class Produit {
    
    @Id // Identifiant primaire
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Génération automatique de l'ID
    private Long id; // Identifiant unique du produit

    @Column(unique = true, nullable = false) 
    private String codeProduit; // Code unique pour chaque produit

    @Column(nullable = false)
    private String nom; // Nom du produit

    @Lob
    @Column(nullable = false)
    private String description; // Description du produit

    @Column(nullable = false)
    private double prix; // Prix du produit

    @Column(nullable = false)
    private int stock; // Quantité en stock

    @OneToMany(mappedBy = "produit", cascade = CascadeType.ALL) // un produit peut avoir plusieurs images . la suppression d'un produit supprime ses images
    @JsonIgnore
    private List<Image> images; // Liste des images associées au produit

    @ManyToOne
    @JoinColumn(name = "categorie_id") // le produit appartient à une catégorie
    @JsonIgnore
    private Categories categorie; // Catégorie du produit

    @Column(updatable = false)
    private LocalDateTime dateCreation = LocalDateTime.now(); // Date de création automatique

    // Constructeur sans argument (obligatoire pour JPA)
    public Produit() {}

    // Constructeur avec tous les champs (optionnel)
    public Produit(Long id, String codeProduit, String nom, String description, double prix, int stock, Categories categorie) {
        this.id = id;
        this.codeProduit = codeProduit;
        this.nom = nom;
        this.description = description;
        this.prix = prix;
        this.stock = stock;
        this.categorie = categorie;
        this.dateCreation = LocalDateTime.now();
    }

    // Getters et setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getCodeProduit() { return codeProduit; }
    public void setCodeProduit(String codeProduit) { this.codeProduit = codeProduit; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public double getPrix() { return prix; }
    public void setPrix(double prix) { this.prix = prix; }

    public int getStock() { return stock; }
    public void setStock(int stock) { this.stock = stock; }

    public List<Image> getImages() { return images; }
    public void setImages(List<Image> images) { this.images = images; }

    public Categories getCategorie() { return categorie; }
    public void setCategorie(Categories categorie) { this.categorie = categorie; }

    public LocalDateTime getDateCreation() { return dateCreation; }
    public void setDateCreation(LocalDateTime dateCreation) { this.dateCreation = dateCreation; }

    @Override
    public String toString() {
        return "Produit{" +
                ", codeProduit='" + codeProduit + '\'' +
                ", nom='" + nom + '\'' +
                ", description='" + description + '\'' +
                ", prix=" + prix +
                ", stock=" + stock +
                ", categorie=" + (categorie != null ? categorie.getNom() : "null") +
                
                '}';
    }
}
