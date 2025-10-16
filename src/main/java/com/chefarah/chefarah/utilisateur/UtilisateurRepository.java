package com.chefarah.chefarah.utilisateur;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {

    Optional<Utilisateur> findByEmail(String email); // Chercher un utilisateur par email
}
