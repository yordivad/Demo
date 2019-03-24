import {NgModule} from "@angular/core";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {AppComponent} from "./app.component";
import {AppRoutingModule} from "./routes/app-routing.module";
import {BrowserModule} from "@angular/platform-browser";
import {AuthenticatedGuard} from "./security/AuthenticatedGuard";
import {AuthService} from "./security/AuthService";

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserAnimationsModule,
    BrowserModule,
    AppRoutingModule
  ],
  exports: [
  ],
  providers: [AuthenticatedGuard, AuthService],
  bootstrap: [AppComponent]
})
export class AppModule {

}
