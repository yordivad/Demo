import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {LoginComponent} from "../components/security/login/login.component";
import {AuthenticatedGuard} from "../security/AuthenticatedGuard";
import {ProductComponent} from "../components/product/product/product.component";
import {ProductModule} from "../components/product/product.module";
import {SecurityModule} from "../components/security/security.module";

const routes: Routes = [
  {
    path:'login',
    component: LoginComponent
  },
  {
    path:'product',
    component: ProductComponent,
    canActivate: [AuthenticatedGuard]
  }
];

@NgModule({
  declarations: [
  ],
  imports: [
    RouterModule.forRoot(routes),
    ProductModule,
    SecurityModule
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
