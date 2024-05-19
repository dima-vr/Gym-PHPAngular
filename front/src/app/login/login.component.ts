import {Component} from '@angular/core';
import {Router} from "@angular/router";
import {MatSnackBar} from "@angular/material/snack-bar";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {AuthenticationService} from "../service/authentication.service";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent {
  loginForm: FormGroup;

  constructor(private authService: AuthenticationService, private router: Router, private snackBar: MatSnackBar, private formBuilder: FormBuilder) {
    this.loginForm = this.buildForm();
  }

  buildForm(): FormGroup {
    return this.formBuilder.group({
      username: [null, Validators.required],
      password: [null, Validators.required]
    });
  }


  login(): void {
    if (this.loginForm.valid) {
      let username = this.loginForm.get('username')?.value;
      let password = this.loginForm.get('password')?.value;
      this.authService.login(username, password).subscribe(
        (data: any) => {
          location.href = "";
        },
        (error) => {
          console.log("error ", error);
          this.showSnackbar('Невірні дані!', 'Закрити');
        }
      )
    } else {
      this.showSnackbar('Невірні дані!', 'Закритри');
    }
  }

  showSnackbar(message: string, action: string): void {
    this.snackBar.open(message, action, {
      duration: 3000
    });
  }
}
