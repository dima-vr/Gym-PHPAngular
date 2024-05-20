import {Component} from '@angular/core';
import {Router} from "@angular/router";
import {MatSnackBar} from "@angular/material/snack-bar";
import {AbstractControl, FormBuilder, FormGroup, ValidatorFn, Validators} from "@angular/forms";
import {User} from "../../models/user.model";
import {AuthenticationService} from "../../services/authentication.service";
import {MatDialog} from "@angular/material/dialog";

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.scss']
})
export class MainComponent {
  registerForm: FormGroup;

  constructor(
    private registerService: AuthenticationService,
    private router: Router,
    private snackBar: MatSnackBar,
    private formBuilder: FormBuilder,
    public dialog: MatDialog
  ) {
    this.registerForm = this.buildForm();
  }

  isSending: boolean = false;
  user: User = new User();

  buildForm(): FormGroup {
    return this.formBuilder.group({
      email: [null, [Validators.required, Validators.email]],
      password: [null, Validators.required],
      confirmPassword: [null, [Validators.required, this.confirmPasswordValidator()]],
      username: [null, Validators.required],
      height: [null, Validators.required],
      weight: [null, Validators.required],
    });
  }

  register(): void {
    if (this.registerForm.valid) {
      this.user.email = this.registerForm.get('email')?.value;
      this.user.password = this.registerForm.get('password')?.value;
      this.user.username = this.registerForm.get('username')?.value;
      this.user.profilePhotoUrl = 'empty';
      this.user.height = this.registerForm.get('height')?.value;
      this.user.weight = this.registerForm.get('weight')?.value;
      this.user.paymentStatus = true;


      this.isSending = true;
      if (this.registerForm.get('password')?.value === this.registerForm.get('confirmPassword')?.value) {
        this.registerService.register(this.user).subscribe(
          (data: any) => {
            this.isSending = false;
            this.showSnackbar("You have been successfully registered", "Ok")
            this.router.navigateByUrl("/login");
          },
          (error) => {
            this.isSending = false;
            if (error.status == 409) {
              this.showSnackbar('A user with this email or username already exists', 'Close');
            } else {
              this.showSnackbar('Server error', 'Close');
            }
          })
      } else {
        this.showSnackbar('Passwords do not match.', 'Close');
      }
    } else {
      this.showSnackbar('The data is entered incorrectly', 'Close');
    }
  }

  showSnackbar(message: string, action: string): void {
    this.snackBar.open(message, action, {
      duration: 5000,
      panelClass: ['blue-snackbar']
    });
  }

  confirmPasswordValidator(): ValidatorFn {
    return (control: AbstractControl): { [key: string]: any } | null => {
      const password = control.parent?.get('password')?.value;
      const confirmPassword = control.value;

      if (password !== confirmPassword) {
        return {passwordMismatch: true};
      }

      return null;
    };
  }
}
