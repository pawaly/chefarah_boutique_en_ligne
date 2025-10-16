package com.chefarah.chefarah.images_produits;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ImageService {

    private final ImageRepository imageRepository;

    public ImageService(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    //  Ajouter une image
    public Image ajouterImage(Image image) {
        return imageRepository.save(image);
    }

    //  Lister toutes les images
    public List<Image> listerToutesLesImages() {
        return imageRepository.findAll();
    }

    //  Chercher une image par ID
    public Image chercherParId(Long id) {
        return imageRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Image introuvable avec l'id : " + id));
    }

    //  Chercher toutes les images d’un produit
    public List<Image> chercherParProduitId(Long produitId) {
        return imageRepository.findByProduitId(produitId);
    }

    // Mettre à jour une image
    public Image updateImage(Long id, Image newImage) {
        return imageRepository.findById(id)
                .map(img -> {
                    img.setUrl(newImage.getUrl());
                    img.setProduit(newImage.getProduit());
                    return imageRepository.save(img);
                })
                .orElseThrow(() -> new RuntimeException("Image non trouvée avec l'id : " + id));
    }

    // Supprimer une image
    public void supprimerImage(Long id) {
        if (!imageRepository.existsById(id)) {
            throw new RuntimeException("Impossible de supprimer : image non trouvée avec l'id : " + id);
        }
        imageRepository.deleteById(id);
    }
}
