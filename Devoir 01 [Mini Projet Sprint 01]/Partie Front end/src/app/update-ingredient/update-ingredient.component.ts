import { Component, OnInit } from '@angular/core'; 
import { ActivatedRoute, Router } from '@angular/router';
import { Recette } from '../model/recette.model';
import { Ingredient } from '../model/Ingredient.model';
import { IngredientService } from '../services/ingredient.service';
import { RecetteWrapper } from '../model/recetteWrapped.model';

@Component({
  selector: 'app-update-ingredient',
  templateUrl: './update-ingredient.component.html',
  styles: []
})
export class UpdateIngredientComponent implements OnInit {

  currentIngredient = new Ingredient();
  recettes!: Recette[];
  updatedRecId?: number | null; // Autoriser null

  constructor(
    private activatedRoute: ActivatedRoute,
    private router: Router,
    private ingredientService: IngredientService
  ) {}
  ngOnInit(): void {
    // Récupérer l'ingrédient à partir de l'ID dans l'URL
    const ingredientId = this.activatedRoute.snapshot.params['id'];
    this.ingredientService.consulterIngredient(ingredientId).subscribe(ingredient => {
        this.currentIngredient = ingredient; // Assignez l'ingrédient récupéré
        this.updatedRecId = ingredient.recette?.idRecette; // Assurez-vous d'assigner l'ID de la recette
    }, (error) => {
        console.error('Erreur lors de la récupération de l\'ingrédient :', error);
    });

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



updateIngredient() {
        this.currentIngredient.recette = this.recettes.find(cat => cat.idRecette == this.updatedRecId

        )!;
             this.ingredientService.updateIngredient(this.currentIngredient).subscribe(prod => {
          this.router.navigate(['ingredients']); }
          );
        }
    
    
    
    }