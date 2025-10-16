package com.chefarah.chefarah.images_produits;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/images")
public class ImageController {

    private final ImageService imageService;

    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    // Ajouter une image
    @PostMapping
    public Image ajouterImage(@RequestBody Image image) {
        return imageService.ajouterImage(image);
    }

    // Lister toutes les images
    @GetMapping
    public List<Image> getAllImages() {
        return imageService.listerToutesLesImages();
    }

    // Rechercher une image par ID
    @GetMapping("/{id}")
    public Image getImageById(@PathVariable Long id) {
        return imageService.chercherParId(id);
    }

    // Rechercher par produit
    @GetMapping("/produit/{produitId}")
    public List<Image> getImagesByProduit(@PathVariable Long produitId) {
        return imageService.chercherParProduitId(produitId);
    }

    // Modifier une image
    @PutMapping("/{id}")
    public Image updateImage(@PathVariable Long id, @RequestBody Image image) {
        return imageService.updateImage(id, image);
    }

    // Supprimer une image
    @DeleteMapping("/{id}")
    public String deleteImage(@PathVariable Long id) {
        imageService.supprimerImage(id);
        return "Image supprimée avec succès ✅";
    }
}
