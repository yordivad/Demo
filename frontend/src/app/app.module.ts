import {NgModule} from "@angular/core";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {AppComponent} from "./app.component";
import {AppRoutingModule} from "./routes/app-routing.module";
import {BrowserModule} from "@angular/platform-browser";
import {AuthenticatedGuard} from "./security/AuthenticatedGuard";
import {SecurityModule} from "./components/security/security.module";
import {TokenInterceptor} from "./security/TokenInterceptor";
import {HTTP_INTERCEPTORS} from "@angular/common/http";

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserAnimationsModule,
    BrowserModule,
    AppRoutingModule,
    SecurityModule
  ],
  exports: [
  ],
  providers: [AuthenticatedGuard, {
    provide: HTTP_INTERCEPTORS,
    useClass: TokenInterceptor,
    multi: true
  }],

  bootstrap: [AppComponent]
})
export class AppModule {

}
