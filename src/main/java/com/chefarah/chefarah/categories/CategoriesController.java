package com.chefarah.chefarah.categories;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoriesController {

    private final CategoriesService categoriesService;

    public CategoriesController(CategoriesService categoriesService) {
        this.categoriesService = categoriesService;
    }

    // Ajouter une catégorie
    @PostMapping
    public Categories ajouterCategorie(@RequestBody Categories categorie) {
        return categoriesService.ajouterCategorie(categorie);
    }

    // Lister toutes les catégories
    @GetMapping
    public List<Categories> getAllCategories() {
        return categoriesService.listerToutesLesCategories();
    }

    // Rechercher une catégorie par ID
    @GetMapping("/{id}")
    public Categories getCategorieById(@PathVariable Long id) {
        return categoriesService.chercherParId(id);
    }

    // Modifier une catégorie
    @PutMapping("/{id}")
    public Categories updateCategorie(@PathVariable Long id, @RequestBody Categories categorie) {
        return categoriesService.updateCategorie(id, categorie);
    }

    // Supprimer une catégorie
    @DeleteMapping("/{id}")
    public String deleteCategorie(@PathVariable Long id) {
        categoriesService.supprimerCategorie(id);
        return "Catégorie supprimée avec succès ✅";
    }
}
