import { APP_INITIALIZER, ApplicationRef, NgModule } from '@angular/core';
import {
  BrowserModule,
  provideClientHydration,
} from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { IngredientsComponent } from './ingredients/ingredients.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { KeycloakAngularModule, KeycloakService } from 'keycloak-angular';

function initializeKeycloak(keycloak: KeycloakService) {
  return () => {
    if (typeof window !== 'undefined') {
      return keycloak.init({
        config: {
          url: 'http://localhost:8180',
          realm: 'Hana-realm',
          clientId: 'Ingredient-app',
        },
        initOptions: {
          onLoad: 'login-required',
          checkLoginIframe: true,
          redirectUri: window.location.origin + '/ingredients',  
          silentCheckSsoRedirectUri: window.location.origin + '/assets/silent-check-sso.html', 
        },
      });
    } else {
      return Promise.resolve();
    }
  };
}

@NgModule({
  declarations: [AppComponent, IngredientsComponent],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    KeycloakAngularModule,
  ],
  providers: [
    {
      provide: APP_INITIALIZER,
      useFactory: initializeKeycloak,
      multi: true,
      deps: [KeycloakService, ApplicationRef],
    },
    provideClientHydration(),
  ],
  bootstrap: [AppComponent],
})
export class AppModule {}
