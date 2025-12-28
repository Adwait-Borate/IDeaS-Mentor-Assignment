import { Component } from '@angular/core';
import { ServiceComponent } from './service/service.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [ServiceComponent],
  template: `<app-service></app-service>`
})
export class AppComponent {}
