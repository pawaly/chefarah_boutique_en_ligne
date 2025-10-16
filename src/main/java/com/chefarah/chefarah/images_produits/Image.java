package com.chefarah.chefarah.images_produits;

import jakarta.persistence.*;
import com.chefarah.chefarah.produit.Produit;

@Entity
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Identifiant unique de l'image

    @Column(nullable = false)
    private String url; // URL ou chemin de l'image

    @ManyToOne
    @JoinColumn(name = "produit_id")
    private Produit produit; // Le produit auquel l'image est associée

    // Constructeur vide pour JPA
    public Image() {}

    // Constructeur complet
    public Image(Long id, String url,Produit produit) {
        this.id = id;
        this.url = url;
        this.produit = produit;
    }

    // Getters et setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }

    public Produit getProduit() { return produit; }
    public void setProduit(Produit produit) { this.produit = produit; }
}
