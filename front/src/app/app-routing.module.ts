import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {LoginComponent} from "./login/login.component";
import {AppComponent} from "./app.component";
import {MainComponent} from "./pages/main/main.component";
import {UserScheduleComponent} from "./pages/user-schedule/user-schedule.component";
import {UserProfileComponent} from "./pages/user-profile/user-profile.component";
import {MyWorkoutComponent} from "./pages/my-workout/my-workout.component";

const routes: Routes = [
  {path: '', component: AppComponent},
  {path: 'login', component: LoginComponent},
  {path:'main', component: MainComponent},
  {path:'user-schedule', component: UserScheduleComponent},
  {path:'user-profile', component: UserProfileComponent},
  {path:'my-workout', component: MyWorkoutComponent},
  { path: '', redirectTo: '/main', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
