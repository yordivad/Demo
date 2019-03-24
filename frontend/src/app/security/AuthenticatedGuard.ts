import {Injectable} from "@angular/core";
import { CanActivate, Router} from "@angular/router";
import {AuthService} from "./AuthService";


@Injectable()
export class AuthenticatedGuard implements CanActivate {
  constructor(private auth:AuthService, private router: Router) {
  }
  public canActivate() {
    console.log("auth");
    if(!this.auth.isAuthenticated()){

      this.router.navigate(["/login"]);
      return false;
    }
    return true;
  }
}
