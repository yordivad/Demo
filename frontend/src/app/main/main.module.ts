import {NgModule} from "@angular/core";
import {MainComponent} from "./main.component";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {MatIconModule, MatListModule, MatSidenavModule, MatToolbarModule} from "@angular/material";
import {FlexLayoutModule} from "@angular/flex-layout";




@NgModule({
 declarations: [
   MainComponent
 ],
  imports:[
    BrowserAnimationsModule,
    MatToolbarModule,
    MatSidenavModule,
    MatIconModule,
    MatListModule,
    FlexLayoutModule
  ],
  exports:[
    MainComponent
  ]
})
export class MainModule{}
