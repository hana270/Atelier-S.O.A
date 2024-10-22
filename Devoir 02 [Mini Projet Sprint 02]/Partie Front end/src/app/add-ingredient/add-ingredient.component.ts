import { Component, OnInit } from '@angular/core';
import { Ingredient } from '../model/Ingredient.model';
import { IngredientService } from '../services/ingredient.service';
import { Recette } from '../model/recette.model';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-ingredient',
  templateUrl: './add-ingredient.component.html',
  styleUrl: './add-ingredient.component.css'
})
export class AddIngredientComponent  implements OnInit {
  
  newIngredient= new Ingredient();
  
  recettes! : Recette[];
  newIdRec! : number;
  newRecette! : Recette;

  constructor(private ingredientService: IngredientService,
    private router :Router) { }

    ngOnInit(): void {

      this.ingredientService.listeRecettes().
      subscribe(cats => {console.log(cats);
      this.recettes = cats._embedded.recettes;
      console.log(cats);
      }
      );

       // Récupérer la liste des recettes
    this.ingredientService.listeRecettes().subscribe(rects => {
      console.log('Réponse du serveur :', rects);
      if (rects && Array.isArray(rects)) {
          this.recettes = rects; // Assurez-vous que rects est un tableau
      } else if (rects?._embedded?.recettes) {
          this.recettes = rects._embedded.recettes;
      } else {
          console.error('Les recettes ne sont pas disponibles dans la réponse');
      }
  });
      }
  

    addIngredient() {
      this.newIngredient.recette = this.recettes.find(cat => cat.idRecette == this.newIdRec)!;
      this.ingredientService.ajouterIngredient(this.newIngredient)
                        .subscribe(prod => {
    console.log(prod);
    this.router.navigate(['ingredients']);
                        }); 
      }
  
        

}
