package com.chefarah.chefarah.categories;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class CategoriesService {

    private final CategoriesRepository categoriesRepository;

    public CategoriesService(CategoriesRepository categoriesRepository) {
        this.categoriesRepository = categoriesRepository;
    }

    public Categories ajouterCategorie(Categories categorie) {
        return categoriesRepository.save(categorie);
    }

    public List<Categories> listerToutesLesCategories() {
        return categoriesRepository.findAll();
    }

    public Categories chercherParId(Long id) {
        return categoriesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Catégorie introuvable avec l'id : " + id));
    }

    public Categories updateCategorie(Long id, Categories newCategorie) {
        return categoriesRepository.findById(id)
                .map(cat -> {
                    cat.setNom(newCategorie.getNom());
                    cat.setDescription(newCategorie.getDescription());
                    return categoriesRepository.save(cat);
                })
                .orElseThrow(() -> new RuntimeException("Catégorie non trouvée !"));
    }

    public void supprimerCategorie(Long id) {
        if (!categoriesRepository.existsById(id)) {
            throw new RuntimeException("Impossible de supprimer : catégorie non trouvée avec l'id : " + id);
        }
        categoriesRepository.deleteById(id);
    }
}
