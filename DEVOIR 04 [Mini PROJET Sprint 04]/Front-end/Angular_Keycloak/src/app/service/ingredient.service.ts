import { Injectable } from '@angular/core';
import { Ingredient } from '../model/ingredient.model';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
  
export class IngredientService {
  apiURL: string = 'http://localhost:8089/ingredients/api/all';


  ingredient! : Ingredient[]; 


  constructor(private http : HttpClient) { 
    
  }

  listeIngredient(): Observable<Ingredient[]> {
    console.log("Making GET request to: " + this.apiURL);
    return this.http.get<Ingredient[]>(this.apiURL);
  }
  
  

     
       
}

