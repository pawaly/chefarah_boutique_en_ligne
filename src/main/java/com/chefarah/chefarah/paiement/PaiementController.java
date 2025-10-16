package com.chefarah.chefarah.paiement;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/paiements")
public class PaiementController {

    private final PaiementService paiementService;

    public PaiementController(PaiementService paiementService) {
        this.paiementService = paiementService;
    }

    // Ajouter un paiement
    @PostMapping
    public Paiement ajouterPaiement(@RequestBody Paiement paiement) {
        return paiementService.ajouterPaiement(paiement);
    }

    // Lister tous les paiements
    @GetMapping
    public List<Paiement> getAllPaiements() {
        return paiementService.listerTousLesPaiements();
    }

    // Rechercher par ID
    @GetMapping("/{id}")
    public Paiement getPaiementById(@PathVariable Long id) {
        return paiementService.chercherParId(id);
    }

    // Modifier un paiement
    @PutMapping("/{id}")
    public Paiement updatePaiement(@PathVariable Long id, @RequestBody Paiement paiement) {
        return paiementService.updatePaiement(id, paiement);
    }

    // Supprimer un paiement
    @DeleteMapping("/{id}")
    public String deletePaiement(@PathVariable Long id) {
        paiementService.supprimerPaiement(id);
        return "Paiement supprimé avec succès ✅";
    }
}
