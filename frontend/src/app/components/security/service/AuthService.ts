import {Injectable} from "@angular/core";
import {User} from "../model/User";
import {HttpClient} from "@angular/common/http";
import {BehaviorSubject} from "rxjs";
import {environment} from "../../../../environments/environment";
import {AuthResponse} from "../model/AuthResponse";

@Injectable()
export class AuthService {

  private token: BehaviorSubject<String>;

  constructor(private http: HttpClient) {
    this.token = <BehaviorSubject<String>>new BehaviorSubject("");
  }

  isAuthenticated() {
    return this.getToken() != "";
  }

  login(user: User) {
    this.http.post<AuthResponse>(`${environment.url}/login`, user)
      .subscribe(data => {
        this.token.next(data.token)
      })
  }

  getToken() {
    return this.token.getValue();
  }

}
