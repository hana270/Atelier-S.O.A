import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { IngredientsComponent } from './ingredients/ingredients.component';
import { AuthGuard } from './guards/secure.guard';



const routes: Routes = [
  { path: 'ingredients', component: IngredientsComponent ,canActivate : [AuthGuard],

    data : {roles:['ADMIN']}
  },
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
