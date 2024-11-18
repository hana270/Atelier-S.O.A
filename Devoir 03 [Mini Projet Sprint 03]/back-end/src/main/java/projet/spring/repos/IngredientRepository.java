package projet.spring.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import projet.spring.entities.*;

import java.util.List;


@RepositoryRestResource(path = "rest")
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
    List<Ingredient> findByNomIngredient(String nom);
    List<Ingredient> findByNomIngredientContains(String nom);

 @Query("select p from Ingredient p where p.recette = ?1")
    List<Ingredient> findByRecette(Recette recette);

 @Query("select i from Ingredient i where i.recette.idRecette = ?1")
 List<Ingredient> findByRecetteId(Long idRecette);
 
 
 List<Ingredient> findByRecetteIdRecette(Long id);

 List<Ingredient> findByOrderByNomIngredientAsc();
}
