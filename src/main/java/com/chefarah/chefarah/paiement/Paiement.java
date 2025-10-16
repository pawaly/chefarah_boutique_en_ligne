package com.chefarah.chefarah.paiement;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import com.chefarah.chefarah.commandes.Commande;

@Entity
@Table(name = "paiement")
public class Paiement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Identifiant unique du paiement

    @OneToOne // Un paiement correspond à une seule commande
    @JoinColumn(name = "commande_id", nullable = false)
    private Commande commande;

    @Column(nullable = false)
    private double montant; // Montant payé

    @Column(nullable = false)
    private String modePaiement; // ex: MOBILE_MONEY, CARTE_BANCAIRE, PAYPAL

    @Column(nullable = false)
    private String statut = "EN_ATTENTE"; // EN_ATTENTE, PAYE, ECHOUE

    @Column(updatable = false)
    private LocalDateTime dateCreation = LocalDateTime.now(); // Date de création du paiement

    @Column
    private LocalDateTime datePaiement; // Date effective du paiement

    // Constructeur vide pour JPA
    public Paiement() {}

    // Constructeur complet
    public Paiement(Long id, Commande commande, double montant, String modePaiement, String statut) {
        this.id = id;
        this.commande = commande;
        this.montant = montant;
        this.modePaiement = modePaiement;
        this.statut = statut;
        this.dateCreation = LocalDateTime.now();
    }

    // Getters et setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Commande getCommande() { return commande; }
    public void setCommande(Commande commande) { this.commande = commande; }

    public double getMontant() { return montant; }
    public void setMontant(double montant) { this.montant = montant; }

    public String getModePaiement() { return modePaiement; }
    public void setModePaiement(String modePaiement) { this.modePaiement = modePaiement; }

    public String getStatut() { return statut; }
    public void setStatut(String statut) { this.statut = statut; }

    public LocalDateTime getDateCreation() { return dateCreation; }
    public void setDateCreation(LocalDateTime dateCreation) { this.dateCreation = dateCreation; }

    public LocalDateTime getDatePaiement() { return datePaiement; }
    public void setDatePaiement(LocalDateTime datePaiement) { this.datePaiement = datePaiement; }
}
