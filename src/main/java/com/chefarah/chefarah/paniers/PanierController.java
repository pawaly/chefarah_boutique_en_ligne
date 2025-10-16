package com.chefarah.chefarah.paniers;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/paniers")
public class PanierController {

    private final PanierService panierService;

    public PanierController(PanierService panierService) {
        this.panierService = panierService;
    }

    // Ajouter un panier
    @PostMapping
    public Panier ajouterPanier(@RequestBody Panier panier) {
        return panierService.ajouterPanier(panier);
    }

    // Lister tous les paniers
    @GetMapping
    public List<Panier> getAllPaniers() {
        return panierService.listerTousLesPaniers();
    }

    // Rechercher un panier par ID
    @GetMapping("/{id}")
    public Panier getPanierById(@PathVariable Long id) {
        return panierService.chercherParId(id);
    }

    // Rechercher le panier d’un utilisateur
    @GetMapping("/utilisateur/{utilisateurId}")
    public List<Panier> getPanierByUtilisateur(@PathVariable Long utilisateurId) {
        return panierService.chercherParUtilisateur(utilisateurId);
    }

    // Modifier un panier
    @PutMapping("/{id}")
    public Panier updatePanier(@PathVariable Long id, @RequestBody Panier panier) {
        return panierService.updatePanier(id, panier);
    }

    // Supprimer un panier
    @DeleteMapping("/{id}")
    public String deletePanier(@PathVariable Long id) {
        panierService.supprimerPanier(id);
        return "Panier supprimé avec succès ✅";
    }
}
