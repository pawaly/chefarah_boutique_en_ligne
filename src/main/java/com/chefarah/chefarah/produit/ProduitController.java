package com.chefarah.chefarah.produit;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/produits")
public class ProduitController {

    private final ProduitService produitService;

    public ProduitController(ProduitService produitService) {
        this.produitService = produitService;
    }

    // Ajouter un produit
    @PostMapping
    public Produit ajouterProduit(@RequestBody Produit produit) {
        return produitService.ajouterProduit(produit);
    }

    // Lister tous les produits
    @GetMapping
    public List<Produit> getAllProduits() {
        return produitService.listerTousLesProduits();
    }

    // Rechercher un produit par ID
    @GetMapping("/{id}")
    public Produit getProduitById(@PathVariable Long id) {
        return produitService.chercherParId(id);
    }

    // Rechercher par nom
    @GetMapping("/search")
    public List<Produit> searchByNom(@RequestParam String nom) {
        return produitService.chercherParNom(nom);
    }

    // Rechercher par catégorie
    @GetMapping("/categorie/{categorie}")
    public List<Produit> searchByCategorie(@PathVariable String categorie) {
        return produitService.chercherParCategorie(categorie);
    }

    // Modifier un produit
    @PutMapping("/{id}")
    public Produit updateProduit(@PathVariable Long id, @RequestBody Produit produit) {
        return produitService.updateProduit(id, produit);
    }

    // Supprimer un produit
    @DeleteMapping("/{id}")
    public String deleteProduit(@PathVariable Long id) {
        produitService.supprimerProduit(id);
        return "Produit supprimé avec succès ✅";
    }
}
