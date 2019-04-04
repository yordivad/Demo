import { Component, OnInit } from '@angular/core';
import {FormControl} from "@angular/forms";
import {AuthService} from "../service/AuthService";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent  {

  password = new FormControl("");
  user = new FormControl('');


  constructor(private authService: AuthService) {}

  login() {
    this.authService.login({ user: this.user.value, password: this.password.value});
  }

}
