import { Component, OnInit } from '@angular/core';
import {FormControl} from "@angular/forms";
import {AuthService} from "../service/AuthService";
import {Router} from "@angular/router";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent  {

  password = new FormControl("");
  user = new FormControl('');


  constructor(private router: Router,  private authService: AuthService) {}

  login() {
    this.authService
      .login({ user: this.user.value, password: this.password.value})
      .subscribe(token => {
        this.router.navigate(["/home"]);
    });
  }

}
