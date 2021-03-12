import { NgModule } from '@angular/core';
import { MatCardModule } from '@angular/material/card';
import { MatButtonModule} from '@angular/material/button';
import { MatMenuModule } from '@angular/material/menu';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatIconModule } from '@angular/material/icon';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatDialogModule } from '@angular/material/dialog';
import {EmployeeDeleteComponent} from './component/employee-demo/employee-delete/employee-delete.component';
import {CustomerDeleteComponent} from './component/customers/customer-delete/customer-delete.component';
import {SotietkiemDeleteComponent} from './component/sotietkiem/sotietkiem-delete/sotietkiem-delete.component';
@NgModule({
  imports: [
    MatButtonModule,
    MatMenuModule,
    MatToolbarModule,
    MatIconModule,
    MatCardModule,
    BrowserAnimationsModule,
    MatDialogModule
  ],
  exports: [
    MatButtonModule,
    MatMenuModule,
    MatToolbarModule,
    MatIconModule,
    MatCardModule,
    BrowserAnimationsModule,
    MatDialogModule
  ],
  providers: [],
  entryComponents: [EmployeeDeleteComponent, CustomerDeleteComponent, SotietkiemDeleteComponent]
})

export class MaterialModule {  }
