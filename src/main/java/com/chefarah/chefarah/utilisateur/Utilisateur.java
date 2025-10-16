package com.chefarah.chefarah.utilisateur;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import com.chefarah.chefarah.commandes.Commande;
import com.chefarah.chefarah.paniers.Panier;
import com.chefarah.chefarah.avis.Avis;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nom; // nom de famille

    @Column(nullable = false)
    private String prenom; // prénom

    @Column(nullable = false, unique = true)
    private String email; // utilisé comme identifiant

    @Column(nullable = false)
    private String motDePasse; // stocké de manière sécurisée (haché)

    @Column(nullable = false)
    private String telephone; // numéro de téléphone

    @Column(nullable = false)
    private String adresse; // adresse

    @Column(nullable = false)
    private String role = "CLIENT"; // par défaut

    @Column(updatable = false)
    private LocalDateTime dateCreation = LocalDateTime.now(); // date de création du compte

    // Relations
    @OneToMany(mappedBy = "utilisateur", cascade = CascadeType.ALL) 
    @JsonIgnore
    private List<Panier> paniers; // Un utilisateur peut avoir plusieurs paniers

    @OneToMany(mappedBy = "utilisateur", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Commande> commandes; // Un utilisateur peut avoir plusieurs commandes

    @OneToMany(mappedBy = "utilisateur", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Avis> avis; // Un utilisateur peut laisser plusieurs avis

    // Constructeur vide pour JPA
    public Utilisateur() {}

    // Constructeur complet
    public Utilisateur(Long id, String nom, String prenom, String email, String motDePasse, String telephone, String adresse, String role) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.motDePasse = motDePasse;
        this.telephone = telephone;
        this.adresse = adresse;
        this.role = role;
        this.dateCreation = LocalDateTime.now();
    }

    // Getters et setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getPrenom() { return prenom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getMotDePasse() { return motDePasse; }
    public void setMotDePasse(String motDePasse) { this.motDePasse = motDePasse; }

    public String getTelephone() { return telephone; }
    public void setTelephone(String telephone) { this.telephone = telephone; }

    public String getAdresse() { return adresse; }
    public void setAdresse(String adresse) { this.adresse = adresse; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public LocalDateTime getDateCreation() { return dateCreation; }
    public void setDateCreation(LocalDateTime dateCreation) { this.dateCreation = dateCreation; }

    public List<Panier> getPaniers() { return paniers; }
    public void setPaniers(List<Panier> paniers) { this.paniers = paniers; }

    public List<Commande> getCommandes() { return commandes; }
    public void setCommandes(List<Commande> commandes) { this.commandes = commandes; }

    public List<Avis> getAvis() { return avis; }
    public void setAvis(List<Avis> avis) { this.avis = avis; }
}
