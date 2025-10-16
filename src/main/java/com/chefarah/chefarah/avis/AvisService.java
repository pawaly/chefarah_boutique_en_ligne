package com.chefarah.chefarah.avis;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AvisService {

    private final AvisRepository avisRepository;

    public AvisService(AvisRepository avisRepository) {
        this.avisRepository = avisRepository;
    }

    // Ajouter un avis
    public Avis ajouterAvis(Avis avis) {
        return avisRepository.save(avis);
    }

    // Lister tous les avis
    public List<Avis> listerTousLesAvis() {
        return avisRepository.findAll();
    }

    //  Chercher un avis par ID
    public Avis chercherParId(Long id) {
        return avisRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Avis introuvable avec l'id : " + id));
    }

    //  Chercher les avis d’un produit
    public List<Avis> chercherParProduit(Long produitId) {
        return avisRepository.findByProduitId(produitId);
    }

    // Chercher les avis d’un utilisateur
    public List<Avis> chercherParUtilisateur(Long utilisateurId) {
        return avisRepository.findByUtilisateurId(utilisateurId);
    }

    //  Mettre à jour un avis
    public Avis updateAvis(Long id, Avis newAvis) {
        return avisRepository.findById(id)
                .map(a -> {
                    a.setNote(newAvis.getNote());
                    a.setCommentaire(newAvis.getCommentaire());
                    a.setProduit(newAvis.getProduit());
                    a.setUtilisateur(newAvis.getUtilisateur());
                    return avisRepository.save(a);
                })
                .orElseThrow(() -> new RuntimeException("Avis non trouvé avec l'id : " + id));
    }

    // Supprimer un avis
    public void supprimerAvis(Long id) {
        if (!avisRepository.existsById(id)) {
            throw new RuntimeException("Impossible de supprimer : avis non trouvé avec l'id : " + id);
        }
        avisRepository.deleteById(id);
    }
}
