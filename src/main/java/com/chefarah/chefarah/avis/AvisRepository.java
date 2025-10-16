package com.chefarah.chefarah.avis;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AvisRepository extends JpaRepository<Avis, Long> {

    List<Avis> findByProduitId(Long produitId); // Lister les avis d’un produit
    List<Avis> findByUtilisateurId(Long utilisateurId); // Lister les avis d’un utilisateur
}
