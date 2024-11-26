package projet.spring.service;


import java.util.List;

import projet.spring.entities.Ingredient;
import projet.spring.entities.Recette;

public interface IngredientService {
    Ingredient saveIngredient(Ingredient ingredient);
    Ingredient updateIngredient(Ingredient ingredient);
    void deleteIngredient(Ingredient ingredient);
    void deleteIngredientById(Long id);
    Ingredient getIngredient(Long id);
    List<Ingredient> getAllIngredients();
    
    
    List<Ingredient> findByNomIngredient(String nom);
    List<Ingredient> findByNomIngredientContains(String nom);
    List<Ingredient> findByRecette (Recette r);
    List<Ingredient> findByRecetteIdRecette(Long id);
    List<Ingredient> findByOrderByNomIngredientAsc();


}