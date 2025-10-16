package com.chefarah.chefarah.avis;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/avis")
public class AvisController {

    private final AvisService avisService;

    public AvisController(AvisService avisService) {
        this.avisService = avisService;
    }

    // Ajouter un avis
    @PostMapping
    public Avis ajouterAvis(@RequestBody Avis avis) {
        return avisService.ajouterAvis(avis);
    }

    // Lister tous les avis
    @GetMapping
    public List<Avis> getAllAvis() {
        return avisService.listerTousLesAvis();
    }

    // Rechercher un avis par ID
    @GetMapping("/{id}")
    public Avis getAvisById(@PathVariable Long id) {
        return avisService.chercherParId(id);
    }

    // Rechercher les avis d’un produit
    @GetMapping("/produit/{produitId}")
    public List<Avis> getAvisByProduit(@PathVariable Long produitId) {
        return avisService.chercherParProduit(produitId);
    }

    // Rechercher les avis d’un utilisateur
    @GetMapping("/utilisateur/{utilisateurId}")
    public List<Avis> getAvisByUtilisateur(@PathVariable Long utilisateurId) {
        return avisService.chercherParUtilisateur(utilisateurId);
    }

    // Modifier un avis
    @PutMapping("/{id}")
    public Avis updateAvis(@PathVariable Long id, @RequestBody Avis avis) {
        return avisService.updateAvis(id, avis);
    }

    // Supprimer un avis
    @DeleteMapping("/{id}")
    public String deleteAvis(@PathVariable Long id) {
        avisService.supprimerAvis(id);
        return "Avis supprimé avec succès ✅";
    }
}
