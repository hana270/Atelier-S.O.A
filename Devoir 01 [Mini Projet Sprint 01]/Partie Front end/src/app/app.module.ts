import { NgModule } from '@angular/core';
import { BrowserModule, provideClientHydration } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { IngredientsComponent } from './ingredients/ingredients.component';
import { AddIngredientComponent } from './add-ingredient/add-ingredient.component';
import { FormsModule } from '@angular/forms';
import { UpdateIngredientComponent } from './update-ingredient/update-ingredient.component';
import { HttpClientModule } from '@angular/common/http';
import { RechercheParRecetteComponent } from './recherche-par-recette/recherche-par-recette.component';
import { RechercheParNomComponent } from './recherche-par-nom/recherche-par-nom.component';
import { SearchFilterPipe } from './search-filter.pipe';
import { ListeRecettesComponent } from './liste-recettes/liste-recettes.component';
import { UpdateRecetteComponent } from './update-recette/update-recette.component';
import { LoginComponent } from './login/login.component';
import { ForbiddenComponent } from './forbidden/forbidden.component';

@NgModule({
  declarations: [
    AppComponent,
    IngredientsComponent,
    AddIngredientComponent,
    UpdateIngredientComponent,
    RechercheParRecetteComponent,
    RechercheParNomComponent,
    SearchFilterPipe,
    ListeRecettesComponent,
    UpdateRecetteComponent,
    LoginComponent,
    ForbiddenComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [
    provideClientHydration()
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
