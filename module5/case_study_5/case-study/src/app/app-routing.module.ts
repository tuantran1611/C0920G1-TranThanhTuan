import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Routes, RouterModule } from '@angular/router';
import { Ng2SearchPipeModule } from 'ng2-search-filter';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import {NgxPaginationModule} from 'ngx-pagination';

import { HomePageComponent } from './component/home-page/home-page.component';
import { PageNotFoundComponent } from './component/page-not-found/page-not-found.component';
import { EmployeeListComponent } from './component/employees/employee-list/employee-list.component';
import { EmployeeCreateComponent } from './component/employees/employee-create/employee-create.component';
import { EmployeeEditComponent } from './component/employees/employee-edit/employee-edit.component';
import { EmployeeDeleteComponent } from './component/employees/employee-delete/employee-delete.component';
import {MatDialogModule} from '@angular/material/dialog';
import { CustomerListComponent } from './component/customers/customer-list/customer-list.component';
import { CustomerCreateComponent } from './component/customers/customer-create/customer-create.component';
import { CustomerDeleteComponent } from './component/customers/customer-delete/customer-delete.component';
import { CustomerEditComponent } from './component/customers/customer-edit/customer-edit.component';
import {MatSelectModule} from '@angular/material/select';


const routes: Routes = [
  {path: '', component: HomePageComponent},
  {path: 'employee-list', component: EmployeeListComponent},
  {path: 'employee-create', component: EmployeeCreateComponent},
  {path: 'employee-edit/:id', component: EmployeeEditComponent},
  {path: 'customer-list', component: CustomerListComponent},
  {path: 'customer-create', component: CustomerCreateComponent},
  {path: 'customer-edit/:id', component: CustomerEditComponent},
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
  // tslint:disable-next-line:max-line-length
  declarations: [HomePageComponent, PageNotFoundComponent, EmployeeListComponent, EmployeeCreateComponent, EmployeeEditComponent, EmployeeDeleteComponent, CustomerListComponent, CustomerCreateComponent, CustomerDeleteComponent, CustomerEditComponent],
})
export class AppRoutingModule { }
