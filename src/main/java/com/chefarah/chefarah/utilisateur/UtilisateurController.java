package com.chefarah.chefarah.utilisateur;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/utilisateurs")
public class UtilisateurController {

    private final UtilisateurService utilisateurService;

    public UtilisateurController(UtilisateurService utilisateurService) {
        this.utilisateurService = utilisateurService;
    }

    // Ajouter un utilisateur
    @PostMapping
    public Utilisateur ajouterUtilisateur(@RequestBody Utilisateur utilisateur) {
        return utilisateurService.ajouterUtilisateur(utilisateur);
    }

    // Lister tous les utilisateurs
    @GetMapping
    public List<Utilisateur> getAllUtilisateurs() {
        return utilisateurService.listerTousLesUtilisateurs();
    }

    // Rechercher par ID
    @GetMapping("/{id}")
    public Utilisateur getUtilisateurById(@PathVariable Long id) {
        return utilisateurService.chercherParId(id);
    }

    // Modifier utilisateur
    @PutMapping("/{id}")
    public Utilisateur updateUtilisateur(@PathVariable Long id, @RequestBody Utilisateur utilisateur) {
        return utilisateurService.updateUtilisateur(id, utilisateur);
    }

    // Supprimer utilisateur
    @DeleteMapping("/{id}")
    public String deleteUtilisateur(@PathVariable Long id) {
        utilisateurService.supprimerUtilisateur(id);
        return "Utilisateur supprimé avec succès ✅";
    }
}
