package projet.spring.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import projet.spring.entities.Ingredient;
import projet.spring.entities.Recette;
import projet.spring.repos.RecetteRepository;

@RestController
@RequestMapping("/api/cat")
@CrossOrigin("*")
public class RecetteRESTController {
	
	
	@Autowired
	RecetteRepository recetteRepository;
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Recette> getAllRecettes(){
		
		return recetteRepository.findAll();
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public Recette getRecetteById(@PathVariable("id") Long id) {
		return recetteRepository.findById(id).get();
	}

	@RequestMapping(method = RequestMethod.POST)
	public Recette createRecette(@RequestBody Recette r) {
	    r.setIdRecette(null);
	    return recetteRepository.save(r);
	}

    @RequestMapping(value="/{id}", method = RequestMethod.PUT)
    public Recette updateRecette(@RequestBody Recette r) {
        return recetteRepository.save(r);
    }
 
    @RequestMapping(value="/{id}", method = RequestMethod.DELETE)
    public void deleteIngredient(@PathVariable("id") Long id) {
    	recetteRepository.deleteById(id);
    }
}
