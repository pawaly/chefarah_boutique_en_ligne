package com.chefarah.chefarah.paniers;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PanierRepository extends JpaRepository<Panier, Long> {

    List<Panier> findByUtilisateurId(Long utilisateurId); // Lister les paniers d’un utilisateur
}
