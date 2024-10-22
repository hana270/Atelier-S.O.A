package projet.spring.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import projet.spring.entities.Ingredient;
import projet.spring.entities.Recette;
import projet.spring.repos.IngredientRepository;

@Service
public class IngredientServiceImpl implements IngredientService {

    @Autowired
    private IngredientRepository ingredientRepository;

    @Override
    public Ingredient saveIngredient(Ingredient ingredient) {
        return ingredientRepository.save(ingredient);
    }

    @Override
    public Ingredient updateIngredient(Ingredient ingredient) {
        if (!ingredientRepository.existsById(ingredient.getIdIngredient())) {
            throw new ResourceNotFoundException("Ingredient not found with id " + ingredient.getIdIngredient());
        }
        return ingredientRepository.save(ingredient);
    }

    @Override
    public void deleteIngredient(Ingredient ingredient) {
        ingredientRepository.delete(ingredient);
    }

    @Override
    public void deleteIngredientById(Long id) {
        ingredientRepository.deleteById(id);
    }

    @Override
    public Ingredient getIngredient(Long id) {
        return ingredientRepository.findById(id).orElse(null);
    }

    @Override
    public List<Ingredient> getAllIngredients() {
        return ingredientRepository.findAll();
    }
    
    @Override
    public List<Ingredient> findByNomIngredient(String nom) {
    	return ingredientRepository.findByNomIngredient(nom);
    }
    
    @Override
    public List<Ingredient> findByNomIngredientContains(String nom) {
    	return ingredientRepository.findByNomIngredientContains(nom);
    }
    
    
    @Override
    public List<Ingredient> findByRecette(Recette c) {
    	return ingredientRepository.findByRecette(c);
    }
    @Override
    public List<Ingredient> findByRecetteIdRecette(Long id) {
    	return ingredientRepository.findByRecetteIdRecette(id);
    }
    @Override
    public List<Ingredient> findByOrderByNomIngredientAsc() {
    	return ingredientRepository.findByOrderByNomIngredientAsc();
    }

	
}

