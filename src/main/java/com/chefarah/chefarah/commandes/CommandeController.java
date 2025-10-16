package com.chefarah.chefarah.commandes;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/commandes")
public class CommandeController {

    private final CommandeService commandeService;

    public CommandeController(CommandeService commandeService) {
        this.commandeService = commandeService;
    }

    // Ajouter une commande
    @PostMapping
    public Commande ajouterCommande(@RequestBody Commande commande) {
        return commandeService.ajouterCommande(commande);
    }

    // Lister toutes les commandes
    @GetMapping
    public List<Commande> getAllCommandes() {
        return commandeService.listerToutesLesCommandes();
    }

    // Rechercher par ID
    @GetMapping("/{id}")
    public Commande getCommandeById(@PathVariable Long id) {
        return commandeService.chercherParId(id);
    }

    // Rechercher par utilisateur
    @GetMapping("/utilisateur/{utilisateurId}")
    public List<Commande> getCommandesByUtilisateur(@PathVariable Long utilisateurId) {
        return commandeService.chercherParUtilisateur(utilisateurId);
    }

    // Modifier une commande
    @PutMapping("/{id}")
    public Commande updateCommande(@PathVariable Long id, @RequestBody Commande commande) {
        return commandeService.updateCommande(id, commande);
    }

    // Supprimer une commande
    @DeleteMapping("/{id}")
    public String deleteCommande(@PathVariable Long id) {
        commandeService.supprimerCommande(id);
        return "Commande supprimée avec succès ✅";
    }
}
