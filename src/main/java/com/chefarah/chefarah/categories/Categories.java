package com.chefarah.chefarah.categories;

import jakarta.persistence.*;
import java.util.*;
import com.chefarah.chefarah.produit.Produit;

@Entity
public class Categories {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Identifiant unique de la catégorie

    @Column(nullable = false, unique = true)
    private String nom; // Nom de la catégorie, ex: Parfum, Gel douche, Skin Care

    @Lob
    @Column(nullable = true)
    private String description; // Description optionnelle de la catégorie

    @OneToMany(mappedBy = "categorie", cascade = CascadeType.ALL)
    private List<Produit> produits = new ArrayList<>(); // Liste des produits associés à cette catégorie
    // Constructeur vide pour JPA
    public Categories() {}

    // Constructeur complet
    public Categories(Long id, String nom, String description) {
        this.id = id;
        this.nom = nom;
        this.description = description;
    }
     // Getters et setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

  public List<String> getProduits() { 
    if (produits == null) {
        return Collections.emptyList(); // renvoie une liste vide au lieu de null
    }
    return produits.stream().map(Produit::getNom).toList();
}

    public void setProduits(List<Produit> produits) { 
        this.produits = (produits != null) ? produits : new ArrayList<>();
    }
    @Override
    public String toString() {
        return "Categories{" +
                ", nom='" + nom + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

}
