import { AuthService } from './../services/auth.service';
import { Component, OnInit } from '@angular/core';
import { Ingredient } from '../model/Ingredient.model';
import { IngredientService } from '../services/ingredient.service';

@Component({
  selector: 'app-ingredients',
  templateUrl: './ingredients.component.html',
  styleUrl: './ingredients.component.css'
})
export class IngredientsComponent implements OnInit {
  ingredients?: Ingredient[];


  constructor(private ingredientService: IngredientService
,public AuthService :AuthService) {
    //this.ingredients = ingredientService.listeIngredients();
  }

  ngOnInit(): void {
    console.log(  this.chargerIngredients());
     this.chargerIngredients();
  }
  
  chargerIngredients(){
    this.ingredientService.listeIngredients().subscribe(prods => {
    console.log(prods);
    this.ingredients= prods;
    });
    }  
    
  supprimerIngredient(ing: Ingredient) {

    let conf = confirm("Etes-vous sûr ?");
    if (conf)
    this.ingredientService.supprimerIngredient(ing.idIngredient!).subscribe(() => {
    console.log("ingredient supprimé");
    this.chargerIngredients();
    });
    

  }

}
