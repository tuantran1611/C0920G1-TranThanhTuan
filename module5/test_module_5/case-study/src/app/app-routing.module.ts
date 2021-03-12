import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Routes, RouterModule } from '@angular/router';
import { Ng2SearchPipeModule } from 'ng2-search-filter';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import {NgxPaginationModule} from 'ngx-pagination';

import { HomePageComponent } from './component/home-page/home-page.component';
import { PageNotFoundComponent } from './component/page-not-found/page-not-found.component';
import {MatDialogModule} from '@angular/material/dialog';
import { CustomerListComponent } from './component/customers/customer-list/customer-list.component';
import { CustomerCreateComponent } from './component/customers/customer-create/customer-create.component';
import { CustomerDeleteComponent } from './component/customers/customer-delete/customer-delete.component';
import { CustomerEditComponent } from './component/customers/customer-edit/customer-edit.component';
import {MatSelectModule} from '@angular/material/select';
import { SotietkiemListComponent } from './component/sotietkiem/sotietkiem-list/sotietkiem-list.component';
import { SotietkiemEditComponent } from './component/sotietkiem/sotietkiem-edit/sotietkiem-edit.component';
import { SotietkiemDeleteComponent } from './component/sotietkiem/sotietkiem-delete/sotietkiem-delete.component';
import { EmployeeListComponent } from './component/employee-demo/employee-list/employee-list.component';
import { EmployeeCreateComponent } from './component/employee-demo/employee-create/employee-create.component';
import { EmployeeEditComponent } from './component/employee-demo/employee-edit/employee-edit.component';
import { EmployeeDeleteComponent } from './component/employee-demo/employee-delete/employee-delete.component';


const routes: Routes = [
  {path: '', component: HomePageComponent},
  {path: 'employee-list', component: EmployeeListComponent},
  {path: 'employee-edit/:id', component: EmployeeEditComponent},
  {path: 'employee-create', component: EmployeeCreateComponent},
  {path: '**' , component: PageNotFoundComponent}
];

@NgModule({
  imports: [
    CommonModule,
    RouterModule.forRoot(routes),
    Ng2SearchPipeModule,
    FormsModule,
    NgxPaginationModule,
    ReactiveFormsModule,
    MatDialogModule,
    MatSelectModule
  ],
  exports: [RouterModule],
  declarations: [
    HomePageComponent, PageNotFoundComponent, CustomerListComponent,
    CustomerCreateComponent, CustomerDeleteComponent, CustomerEditComponent,
    SotietkiemListComponent, SotietkiemEditComponent, SotietkiemDeleteComponent,
    EmployeeListComponent,
    EmployeeCreateComponent,
    EmployeeEditComponent,
    EmployeeDeleteComponent],
})
export class AppRoutingModule { }
