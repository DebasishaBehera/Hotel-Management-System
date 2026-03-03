import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Router, RouterModule } from '@angular/router';
import { AuthService } from '../services/auth';

@Component({
  selector: 'app-signup',
  standalone: true,
  imports: [CommonModule, FormsModule, RouterModule],
  templateUrl: './signup.html',
  styleUrl: '../login/login.css'
})
export class SignupComponent {
  name = '';
  email = '';
  password = '';
  message = '';

  constructor(private auth: AuthService, private router: Router) {}

  onSignup() {
    const user = { name: this.name, email: this.email, password: this.password };
    this.auth.signup(user).subscribe({
      next: () => {
        this.message = 'Signup successful! Please login.';
        this.router.navigate(['/login']);
      },
      error: () => {
        this.message = 'Signup failed. Try again.';
      }
    });
  }
}
