package com.chefarah.chefarah.paniers;
import java.util.*;
import org.springframework.stereotype.Service;

@Service
public class PanierService {

     private final PanierRepository panierRepository;

    //constructeur avec injection de dépendance
    public PanierService(PanierRepository panierRepository) {
        this.panierRepository = panierRepository;
    }

    // ajout d'un panier
    public Panier ajouterPanier(Panier panier) {
        return panierRepository.save(panier);
    }

    // liste de tous les paniers
    public List<Panier> listerTousLesPaniers() {
        return panierRepository.findAll();
    }

    // chercher un panier par son id
    public Panier chercherParId(Long id) {
        return panierRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Panier introuvable avec l'id : " + id));
    }

    // chercher des paniers par utilisateur
    public List<Panier> chercherParUtilisateur(Long utilisateurId) {
        return panierRepository.findByUtilisateurId(utilisateurId);
    }


    // mettre à jour un panier
    public Panier updatePanier(Long id, Panier newPanier) {
        return panierRepository.findById(id)
                .map(p -> {
                    p.setUtilisateur(newPanier.getUtilisateur());
                    p.setProduits(newPanier.getProduits());
                    return panierRepository.save(p);
                })
                .orElseThrow(() -> new RuntimeException("Panier non trouvé !"));
    }

    // supprimer un panier par son id
    public void supprimerPanier(Long id) {
        panierRepository.deleteById(id);
    }
    
}
