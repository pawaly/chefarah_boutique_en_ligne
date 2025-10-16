package com.chefarah.chefarah.paiement;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface PaiementRepository extends JpaRepository<Paiement, Long> {

    Optional<Paiement> findByCommandeId(Long commandeId); // Chercher le paiement d’une commande
}
