package projet.spring;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import projet.spring.entities.*;
import projet.spring.repos.IngredientRepository;

import java.util.List;

@SpringBootTest
class ProjetRecettesApplicationTests {

    @Autowired
    private IngredientRepository ingredientRepository;

    @Test
    void contextLoads() {
    }

    @Test
    public void testCreateIngredient() {
        Ingredient ingredient = new Ingredient(null, "pommes", 2.0, "pcs"); 
        
        ingredientRepository.save(ingredient);
    }

    @Test
    public void testFindIngredient() {
        Ingredient ingredient = ingredientRepository.findById(1L).orElse(null);
        System.out.println(ingredient);
    }

    @Test
    public void testUpdateIngredient() {
        Ingredient ingredient = ingredientRepository.findById(1L).orElse(null);
        if (ingredient != null) {
            ingredient.setQuantite(1000.0);
            ingredientRepository.save(ingredient);
        }
    }

    @Test
    public void testDeleteIngredient() {
        ingredientRepository.deleteById(1L);
    }

    @Test
    public void testListerTousIngredients() {
        List<Ingredient> ingredients = ingredientRepository.findAll();
        for (Ingredient ingredient : ingredients) {
            System.out.println(ingredient);
        }
    }
    
    
    @Test
    public void testFindByNomIngredient()
    {
    List<Ingredient> prods = ingredientRepository.findByNomIngredient("pomme");
    for (Ingredient p : prods)
    {
    System.out.println(p);
    }
 } 
    @Test
    public void testFindByNomIngredientContains ()
    {
    List<Ingredient> prods=ingredientRepository.findByNomIngredientContains("pomme");
    for (Ingredient p : prods)
    {
    System.out.println(p);
    } }

    @Test
    public void testFindByRecette() {
        List<Ingredient> ingredients = ingredientRepository.findByRecetteId(Long.valueOf(2));
        for (Ingredient ingredient : ingredients) {
            System.out.println(ingredient);
        }
    }


    @Test
    public void findByCategorieIdCat(){
    	List<Ingredient> prods = ingredientRepository.findByRecetteIdRecette(Long.valueOf(2));	
    	for (Ingredient p : prods){
    System.out.println(p);
    }
     }
    @Test
    public void testfindByOrderByNomIngredientAsc()
    {
    List<Ingredient> prods =
    		ingredientRepository.findByOrderByNomIngredientAsc();
    for (Ingredient p : prods)
    {
    System.out.println(p);
    }
    }
    
}
