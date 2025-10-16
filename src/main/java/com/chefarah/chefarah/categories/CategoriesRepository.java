package com.chefarah.chefarah.categories;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface CategoriesRepository extends JpaRepository<Categories, Long> {

    Optional<Categories> findByNom(String nom); // Chercher une catégorie par son nom
}
