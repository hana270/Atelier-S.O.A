import { Component, OnInit } from '@angular/core';
import { Ingredient } from '../model/ingredient.model';
import { IngredientService } from '../service/ingredient.service';

@Component({
  selector: 'app-ingredients',
  templateUrl: './ingredients.component.html',
  styleUrl: './ingredients.component.css'
})


export class IngredientsComponent implements OnInit {
  ingredients! : Ingredient[];


      //un tableau de Produit
     
      constructor(private ingredientService: IngredientService ) {
      
      }
   

      ngOnInit(): void {

        this.chargerIngredients();
      }
    
      chargerIngredients(){
        this.ingredientService.listeIngredient().subscribe(prods => {
          console.log(prods);
          this.ingredients = prods;
          });
      }
   

 
}
