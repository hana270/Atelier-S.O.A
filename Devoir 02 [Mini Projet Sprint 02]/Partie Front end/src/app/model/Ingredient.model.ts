import { Recette } from "./recette.model";

export class Ingredient {
    idIngredient?: number;     
    nomIngredient?: string;     
    quantite?: number;          
    uniteMesure?: string; 
  recette? :Recette;   
}
