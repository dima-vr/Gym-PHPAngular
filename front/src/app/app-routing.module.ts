import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {LoginComponent} from "./pages/login/login.component";
import {AppComponent} from "./app.component";
import {MainComponent} from "./pages/main/main.component";
import {UserScheduleComponent} from "./pages/user-schedule/user-schedule.component";
import {UserProfileComponent} from "./pages/user-profile/user-profile.component";
import {MyWorkoutComponent} from "./pages/my-workout/my-workout.component";
import {AuthGuard} from "./guard/auth.guard";

const routes: Routes = [
  {path: '', component: AppComponent},
  {path: 'login', component: LoginComponent},
  {path: 'register', component: MainComponent},
  {path: 'user-schedule', component: UserScheduleComponent, canActivate: [AuthGuard]},
  {path: 'user-profile', component: UserProfileComponent, canActivate: [AuthGuard]},
  {path: 'my-workout', component: MyWorkoutComponent, canActivate: [AuthGuard]},
  {path: '', redirectTo: '/main', pathMatch: 'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
