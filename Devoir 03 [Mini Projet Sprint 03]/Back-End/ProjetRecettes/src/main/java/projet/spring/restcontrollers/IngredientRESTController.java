package projet.spring.restcontrollers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import projet.spring.entities.Ingredient;
import projet.spring.service.IngredientService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class IngredientRESTController {

	@Autowired
	IngredientService ingredientService;

	@RequestMapping(path = "all", method = RequestMethod.GET)
	public List<Ingredient> getAllIngredients() {
		return ingredientService.getAllIngredients();
	}

	@RequestMapping(value = "/getbyid/{id}", method = RequestMethod.GET)
	public Ingredient getIngredientById(@PathVariable("id") Long id) {
		return ingredientService.getIngredient(id);
	}

	@RequestMapping(value = "/adding", method = RequestMethod.POST)
	@PreAuthorize("hasAuthority('ADMIN')")
	public Ingredient createIngredient(@RequestBody Ingredient ingredient) {
		return ingredientService.saveIngredient(ingredient);
	}

	@RequestMapping(value = "/updateing", method = RequestMethod.PUT)
	public Ingredient updateIngredient(@RequestBody Ingredient ingredient) {
		return ingredientService.updateIngredient(ingredient);
	}

	@RequestMapping(value = "/deling/{id}", method = RequestMethod.DELETE)
	public void deleteIngredient(@PathVariable("id") Long id) {
		ingredientService.deleteIngredientById(id);
	}

	@RequestMapping(value = "/ingcrect/{idRecette}", method = RequestMethod.GET)
	public List<Ingredient> getIngredientsByRecetteId(@PathVariable("idRecette") Long idRecette) {
		return ingredientService.findByRecetteIdRecette(idRecette);
	}

	@RequestMapping(value = "/ingsByName/{nomIngredient}", method = RequestMethod.GET)
	public List<Ingredient> findByNomIngredientContains(@PathVariable("nomIngredient") String nomIngredient) {
		return ingredientService.findByNomIngredientContains(nomIngredient);
	}
	
	
	
	/***
	 * 
    @GetMapping("/getbyid/{id}")
    public Ingredient getIngredientById(@PathVariable("id") Long id) {
        Ingredient ingredient = ingredientService.getIngredient(id); 
        if (ingredient != null && ingredient.getImagePath() != null) {
            try {
               Files.delete(Paths.get(System.getProperty("user.home") + "/images/" + ingredient.getImagePath()));
            } catch (IOException e) {
                e.printStackTrace();
                
 }
        }
        return ingredient;
    }
	 * 
	 * 
	 * *****/
}
