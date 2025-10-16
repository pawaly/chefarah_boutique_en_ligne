package com.chefarah.chefarah.commandes;

import java.util.*;

import org.springframework.stereotype.Service;

@Service
public class CommandeService {

       private final CommandeRepository commandeRepository;

    public CommandeService(CommandeRepository commandeRepository) {
        this.commandeRepository = commandeRepository;
    }

    public Commande ajouterCommande(Commande commande) {
        return commandeRepository.save(commande);
    }

    public List<Commande> listerToutesLesCommandes() {
        return commandeRepository.findAll();
    }

    public Commande chercherParId(Long id) {
        return commandeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Commande introuvable avec l'id : " + id));
    }

    public List<Commande> chercherParUtilisateur(Long utilisateurId) {
        return commandeRepository.findByUtilisateurId(utilisateurId);
    }

    public Commande updateCommande(Long id, Commande newCommande) {
        return commandeRepository.findById(id)
                .map(c -> {
                    c.setStatut(newCommande.getStatut());
                    c.setDateCreation(newCommande.getDateCreation());
                    c.setMontantTotal(newCommande.getMontantTotal());
                    c.setUtilisateur(newCommande.getUtilisateur());
                    return commandeRepository.save(c);
                })
                .orElseThrow(() -> new RuntimeException("Commande non trouvée !"));
    }

    public void supprimerCommande(Long id) {
        
        if (!commandeRepository.existsById(id)) {
            throw new RuntimeException("Impossible de supprimer : commande non trouvée avec l'id : " + id);
        }
        commandeRepository.deleteById(id);
    }
    
}
