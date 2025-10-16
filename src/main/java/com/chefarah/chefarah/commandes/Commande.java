package com.chefarah.chefarah.commandes;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import com.chefarah.chefarah.utilisateur.Utilisateur;
import com.chefarah.chefarah.produit.Produit;

@Entity
public class Commande {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Identifiant unique de la commande

    @ManyToOne // Une commande appartient à un utilisateur
    @JoinColumn(name = "utilisateur_id")
    private Utilisateur utilisateur;

    @ManyToMany
    @JoinTable(
        name = "commande_produits",
        joinColumns = @JoinColumn(name = "commande_id"),
        inverseJoinColumns = @JoinColumn(name = "produit_id")
    )
    private List<Produit> produits; // Produits commandés

    @Column(nullable = false)
    private double montantTotal; // Somme des prix des produits

    @Column(nullable = false)
    private String statut = "EN_ATTENTE"; // EN_ATTENTE, PAYEE, EXPEDIEE, ANNULEE

    @Column(updatable = false)
    private LocalDateTime dateCreation = LocalDateTime.now(); // Date de création de la commande

    @Column
    private LocalDateTime datePaiement; // Date du paiement (si payé)

    @Column
    private String modePaiement; // ex: MOBILE_MONEY, CARTE_BANCAIRE, PAYPAL

    // Constructeur vide pour JPA
    public Commande() {}

    // Constructeur complet
    public Commande(Long id, Utilisateur utilisateur, List<Produit> produits, double montantTotal, String statut, String modePaiement) {
        this.id = id;
        this.utilisateur = utilisateur;
        this.produits = produits;
        this.montantTotal = montantTotal;
        this.statut = statut;
        this.modePaiement = modePaiement;
        this.dateCreation = LocalDateTime.now();
    }

    // Getters et setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Utilisateur getUtilisateur() { return utilisateur; }
    public void setUtilisateur(Utilisateur utilisateur) { this.utilisateur = utilisateur; }

    public List<Produit> getProduits() { return produits; }
    public void setProduits(List<Produit> produits) { this.produits = produits; }

    public double getMontantTotal() { return montantTotal; }
    public void setMontantTotal(double montantTotal) { this.montantTotal = montantTotal; }

    public String getStatut() { return statut; }
    public void setStatut(String statut) { this.statut = statut; }

    public LocalDateTime getDateCreation() { return dateCreation; }
    public void setDateCreation(LocalDateTime dateCreation) { this.dateCreation = dateCreation; }

    public LocalDateTime getDatePaiement() { return datePaiement; }
    public void setDatePaiement(LocalDateTime datePaiement) { this.datePaiement = datePaiement; }

    public String getModePaiement() { return modePaiement; }
    public void setModePaiement(String modePaiement) { this.modePaiement = modePaiement; }
}
