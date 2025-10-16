package com.chefarah.chefarah.produit;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ProduitRepository extends JpaRepository<Produit, Long> {

    	// Chercher par nom (contient, insensible à la casse)
    List<Produit> findByNomContainingIgnoreCase(String nom);

    // Chercher par catégorie
    List<Produit> findByCategorieNom(String nomCategorie);

    List<Produit> findByCategorieNomIgnoreCase(String nomCategorie);
}
