package com.chefarah.chefarah.paiement;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PaiementService {

    private final PaiementRepository paiementRepository;

    public PaiementService(PaiementRepository paiementRepository) {
        this.paiementRepository = paiementRepository;
    }

    //  Ajouter un paiement
    public Paiement ajouterPaiement(Paiement paiement) {
        return paiementRepository.save(paiement);
    }

    //  Lister tous les paiements
    public List<Paiement> listerTousLesPaiements() {
        return paiementRepository.findAll();
    }

    //  Chercher un paiement par ID
    public Paiement chercherParId(Long id) {
        return paiementRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Paiement introuvable avec l'id : " + id));
    }

    //  Chercher les paiements liés à une commande donnée
    public Paiement chercherParCommandeId(Long commandeId) {
        return paiementRepository.findByCommandeId(commandeId)
                .orElseThrow(() -> new RuntimeException("Aucun paiement trouvé pour la commande ID : " + commandeId));
    }

    //  Mettre à jour un paiement
    public Paiement updatePaiement(Long id, Paiement newPaiement) {
        return paiementRepository.findById(id)
                .map(p -> {
                    p.setMontant(newPaiement.getMontant());
                    p.setModePaiement(newPaiement.getModePaiement());
                    p.setStatut(newPaiement.getStatut());
                    p.setDatePaiement(newPaiement.getDatePaiement());
                    return paiementRepository.save(p);
                })
                .orElseThrow(() -> new RuntimeException("Paiement non trouvé avec l'id : " + id));
    }

    //  Supprimer un paiement
    public void supprimerPaiement(Long id) {
        if (!paiementRepository.existsById(id)) {
            throw new RuntimeException("Impossible de supprimer : paiement non trouvé avec l'id : " + id);
        }
        paiementRepository.deleteById(id);
    }
}
