package com.chefarah.chefarah.utilisateur;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UtilisateurService {

    private final UtilisateurRepository utilisateurRepository;

    //constructeur avec injection de dépendance
    public UtilisateurService(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    // ajout d'un utilisateur
    public Utilisateur ajouterUtilisateur(Utilisateur utilisateur) {
        return utilisateurRepository.save(utilisateur);
    }
    // liste de tous les utilisateurs
    public List<Utilisateur> listerTousLesUtilisateurs() {
        return utilisateurRepository.findAll();
    }

    // chercher un utilisateur par son id
    public Utilisateur chercherParId(Long id) {
        return utilisateurRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Utilisateur introuvable avec l'id : " + id));
    }

    // chercher un utilisateur par son email
    public Utilisateur chercherParEmail(String email) {
        return utilisateurRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Utilisateur introuvable avec l'email : " + email));
    }

    // mettre à jour un utilisateur
    public Utilisateur updateUtilisateur(Long id, Utilisateur newUtilisateur) {
        return utilisateurRepository.findById(id)
                .map(u -> {
                    u.setNom(newUtilisateur.getNom());
                    u.setPrenom(newUtilisateur.getPrenom());
                    u.setEmail(newUtilisateur.getEmail());
                    u.setMotDePasse(newUtilisateur.getMotDePasse());
                    u.setAdresse(newUtilisateur.getAdresse());
                    u.setTelephone(newUtilisateur.getTelephone());
                    u.setRole(newUtilisateur.getRole());
                    return utilisateurRepository.save(u);
                })
                .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé !"));
    }

    // supprimer un utilisateur par son id
    public void supprimerUtilisateur(Long id) {
        utilisateurRepository.deleteById(id);
    }
}
