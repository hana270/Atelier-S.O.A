import { Injectable } from '@angular/core';
import { Ingredient } from '../model/Ingredient.model';
import { Recette } from '../model/recette.model';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { apiURL } from '../config';
import { RecetteWrapper } from '../model/recetteWrapped.model';

const httpOptions = {
  headers: new HttpHeaders( {'Content-Type': 'application/json'} )
  };
  

@Injectable({
  providedIn: 'root'
})
export class IngredientService {
 
  apiURLRec: string = 'http://localhost:8081/ingredients/api/cat';
  ingredients: Ingredient[] = []; // Un tableau d'Ingrédients
//recettes : Recette[] ;
constructor(private http : HttpClient) {
 /* this.recettes = [
    {
        idRecette: 1,
        dateCreation: new Date('2024-01-01'),
        description: 'Recette de PC',
        nomRecette: 'Gâteau au Chocolat'
    },
    {
      idRecette: 2,
      dateCreation: new Date('2024-02-01'),
        description: 'Recette d\'imprimante',
        nomRecette: 'Tarte aux Pommes'
    },
    {
      idRecette: 3,
      dateCreation: new Date('2024-02-02'),
        description: 'Recette de dessert',
        nomRecette: 'Crêpes Suzette'
    }
];
*/

  this.ingredients = [
      {
        idIngredient: 1,
        nomIngredient: "Farine",
        quantite: 500,
        uniteMesure: "g",
       recette : {
        idRecette: 1,
        dateCreation: new Date('2024-01-01'),
        description: 'Recette de PC',
        nomRecette: 'Gâteau au Chocolat'
    }
      }, 
      {
        idIngredient: 2, nomIngredient: "Sucre",
        quantite: 200,
        uniteMesure: "g",
        recette : {
            idRecette: 2,
            dateCreation: new Date('2024-02-01'),
              description: 'Recette d\'imprimante',
              nomRecette: 'Tarte aux Pommes'
             }
      }, 
      { idIngredient: 3,
         nomIngredient: "Oeufs",
          quantite: 6, 
          uniteMesure: "pcs", recette : {
            idRecette: 3,
      dateCreation: new Date('2024-02-02'),
        description: 'Recette de dessert',
        nomRecette: 'Crêpes Suzette'}
        
        }  
  ];
}
  listeIngredients(): Observable<Ingredient[]>{
    return this.http.get<Ingredient[]>(apiURL);
    }
 

  ajouterIngredient( prod: Ingredient):Observable<Ingredient>{
    return this.http.post<Ingredient>(apiURL, prod, httpOptions);
    }


  supprimerIngredient(id : number) {
    const url = `${apiURL}/${id}`;
    return this.http.delete(url, httpOptions);
    }


    consulterIngredient(id: number): Observable<Ingredient> {
      const url = `${apiURL}/${id}`;
      return this.http.get<Ingredient>(url);
      }

      updateIngredient(ing: Ingredient) {
        const url = `${apiURL}/${ing.idIngredient}`;  
        return this.http.put<Ingredient>(url, ing, httpOptions);  
      }
      
  
  
  
  /*
    updateIngredient(ing: Ingredient) {
      const index = this.ingredients.findIndex(i => i.idIngredient === ing.idIngredient);
      if (index > -1) {
        this.ingredients[index] = ing; // Mettre à jour l'ingrédient existant
      }
    }
*/
trierIngredients() {
  console.log("Avant tri:", this.ingredients); // Affiche la liste avant tri
  this.ingredients.sort((n1, n2) => {
    return (n1.idIngredient ?? 0) - (n2.idIngredient ?? 0);
  });
  console.log("Après tri:", this.ingredients); // Affiche la liste après tri
}

listeRecettes(): Observable<RecetteWrapper> {
  return this.http.get<RecetteWrapper>(this.apiURLRec);
}


  /*
  consulterRecette(id: number): Recette | undefined {
    const recette = this.recettes.find(rect => rect.idRecette === id);
    if (!recette) {
      console.error(`Recette avec l'ID ${id} non trouvée.`);
    }
    return recette;
  }*/



    rechercherParRecette(idRecette: number):Observable< Ingredient[]> {
      const url = `${apiURL}/recettes/${idRecette}`;
      return this.http.get<Ingredient[]>(url);
      } 
      
    rechercherParNom(nom: string):Observable< Ingredient[]> {
        const url = `${apiURL}/ingsByName/${nom}`;
        
        return this.http.get<Ingredient[]>(url);
    }


    ajouterRecette( cat: Recette):Observable<Recette>{
      return this.http.post<Recette>(this.apiURLRec, cat, httpOptions);
      }
    
      supprimerRecette(id: number) {
        const url = `${this.apiURLRec}/${id}`;
        return this.http.delete(url, httpOptions);
      }
      
        modifierRecette(cat: Recette): Observable<Recette> {
          const url = `${this.apiURLRec}/${cat.idRecette}`;
          return this.http.put<Recette>(url, cat, httpOptions);
        }
        
}
