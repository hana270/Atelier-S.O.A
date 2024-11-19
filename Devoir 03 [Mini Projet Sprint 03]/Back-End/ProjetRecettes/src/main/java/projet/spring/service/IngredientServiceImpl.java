package projet.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import projet.spring.entities.Image;
import projet.spring.entities.Ingredient;
import projet.spring.entities.Recette;
import projet.spring.repos.ImageRepository;
import projet.spring.repos.IngredientRepository;

@Service
public class IngredientServiceImpl implements IngredientService {

	 @Autowired
	    private IngredientRepository ingredientRepository;
	 @Autowired
	    private ImageRepository imageRepository;

	 @PreAuthorize("hasAuthority('ADMIN')")
	 @Override
    public Ingredient saveIngredient(Ingredient ingredient) {
        return ingredientRepository.save(ingredient);
    }
/*
    @Override
    public Ingredient updateIngredient(Ingredient ingredient) {
        if (!ingredientRepository.existsById(ingredient.getIdIngredient())) {
            throw new ResourceNotFoundException("Ingredient not found with id " + ingredient.getIdIngredient());
        }
        return ingredientRepository.save(ingredient);
    }*/
    
    
@Override
public Ingredient updateIngredient(Ingredient p) {
	//Long oldIngImageId = this.getIngredient(p.getIdIngredient()).getImage().getIdImage();
	//Long newIngImageId = p.getImage().getIdImage();
	Ingredient ingUpdated = ingredientRepository.save(p);
	//if (oldIngImageId != newIngImageId)
		//imageRepository.deleteById(oldIngImageId);
	return ingUpdated;
}

    @Override
    public void deleteIngredient(Ingredient ingredient) {
        ingredientRepository.delete(ingredient);
    }
/*
    @Override
    public void deleteIngredientById(Long id) {
        ingredientRepository.deleteById(id);
    }*/
    
    /*
      
     @Override
public void deleteIngredientById(Long id) {
		Ingredient p = getIngredient(id);
	//suuprimer l'image avant de supprimer le produit
		try {
			Files.delete(Paths.get(System.getProperty("user.home")+"/images/"+p.getImagePath()));
		} catch (IOException e) {
			e.printStackTrace();
		}
			produitRepository.deleteById(id);
		}
		     */
    
    
    @Override
    public void deleteIngredientById(Long id) {
        // Récupérer les images associées à l'ingrédient
        List<Image> images = imageRepository.findImagesByIngredientId(id);

        // Supprimer toutes les images associées
        for (Image image : images) {
            imageRepository.delete(image);
        }

        // Supprimer l'ingrédient
        ingredientRepository.deleteById(id);
    }

    @Override
    public Ingredient getIngredient(Long id) {
        return ingredientRepository.findById(id).get();
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
    
    
    @Override
    public Optional<Ingredient> findById(Long id) {
        return ingredientRepository.findById(id);
    }
	
}

