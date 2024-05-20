import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {LoginComponent} from './pages/login/login.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {MatInputModule} from "@angular/material/input";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {MatButtonModule} from "@angular/material/button";
import {HTTP_INTERCEPTORS, HttpClientModule} from "@angular/common/http";
import {MAT_DIALOG_DATA, MatDialogModule} from "@angular/material/dialog";
import {MatSnackBarModule} from "@angular/material/snack-bar";
import {AuthorizationInterceptor} from "./authorization-interceptor";
import { MainComponent } from './pages/main/main.component';
import { HeaderComponent } from './pages/header/header.component';
import { MyWorkoutComponent } from './pages/my-workout/my-workout.component';
import { UserProfileComponent } from './pages/user-profile/user-profile.component';
import { UserScheduleComponent } from './pages/user-schedule/user-schedule.component';
import {MatCheckboxModule} from "@angular/material/checkbox";

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    MainComponent,
    HeaderComponent,
    MyWorkoutComponent,
    UserProfileComponent,
    UserScheduleComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatInputModule,
    FormsModule,
    ReactiveFormsModule,
    MatButtonModule,
    MatSnackBarModule,
    HttpClientModule,
    MatDialogModule,
    MatCheckboxModule
  ],
  providers: [
    {provide: HTTP_INTERCEPTORS, useClass: AuthorizationInterceptor, multi: true},
    {provide: MAT_DIALOG_DATA, useValue: {}}
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
