import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MainComponent } from './pages/main/main.component';
import {ReactiveFormsModule} from "@angular/forms";
import { HeaderComponent } from './pages/header/header.component';
import { MyWorkoutComponent } from './pages/my-workout/my-workout.component';
import { UserProfileComponent } from './pages/user-profile/user-profile.component';
import { UserScheduleComponent } from './pages/user-schedule/user-schedule.component';

@NgModule({
  declarations: [
    AppComponent,
    MainComponent,
    HeaderComponent,
    MyWorkoutComponent,
    UserProfileComponent,
    UserScheduleComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
