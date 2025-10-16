package com.chefarah.chefarah.produit;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProduitService {

    private final ProduitRepository produitRepository;

    //constructeur avec injection de dépendance
    public ProduitService(ProduitRepository produitRepository) {
        this.produitRepository = produitRepository;
    }
     
    // ajout d'un produit
    public Produit ajouterProduit(Produit produit) {
        return produitRepository.save(produit);
    }

    // liste de tous les produits
    public List<Produit> listerTousLesProduits() {
        return produitRepository.findAll();
    }

    // chercher un produit par son id
    public Produit chercherParId(Long id) {
        return produitRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produit introuvable avec l'id : " + id));
    }

    // chercher des produits par nom (partie du nom)
    public List<Produit> chercherParNom(String nom) {
        return produitRepository.findByNomContainingIgnoreCase(nom);
    }

    // chercher des produits par catégorie
    public List<Produit> chercherParCategorie(String nomCategorie) {
        return produitRepository.findByCategorieNomIgnoreCase(nomCategorie);
    }

    // mettre à jour un produit
    public Produit updateProduit(Long id, Produit newProduit) {
        return produitRepository.findById(id)
                .map(p -> {
                    p.setNom(newProduit.getNom());
                    p.setDescription(newProduit.getDescription());
                    p.setPrix(newProduit.getPrix());
                    p.setStock(newProduit.getStock());
                    p.setCategorie(newProduit.getCategorie());
                    return produitRepository.save(p);
                })
                .orElseThrow(() -> new RuntimeException("Produit non trouvé !"));
    }

    // supprimer un produit par son id
    public void supprimerProduit(Long id) {
        produitRepository.deleteById(id);
    }
}
