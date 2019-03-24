import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  drawerIsOpen: boolean = true;



  drawerToogle(  ) {
    this.drawerIsOpen = !this.drawerIsOpen;
    console.log("aaa")
  }

}
