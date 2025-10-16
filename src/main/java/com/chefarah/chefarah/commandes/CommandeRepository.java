package com.chefarah.chefarah.commandes;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CommandeRepository extends JpaRepository<Commande, Long> {

    List<Commande> findByUtilisateurId(Long utilisateurId); // Lister les commandes d’un utilisateur
}
