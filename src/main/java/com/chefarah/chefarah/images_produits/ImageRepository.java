package com.chefarah.chefarah.images_produits;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ImageRepository extends JpaRepository<Image, Long> {

    List<Image> findByProduitId(Long produitId); // Lister les images d’un produit
}
