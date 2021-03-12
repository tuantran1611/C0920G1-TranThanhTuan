import { Component, OnInit } from '@angular/core';
import {AbstractControl, FormBuilder, FormGroup, Validators} from '@angular/forms';
import {ActivatedRoute, Router} from '@angular/router';
import {CustomerService} from '../../../services/customer.service';

@Component({
  selector: 'app-customer-edit',
  templateUrl: './customer-edit.component.html',
  styleUrls: ['./customer-edit.component.css']
})
export class CustomerEditComponent implements OnInit {

  private customerId;
  public formEditCustomer: FormGroup;

  constructor(
    public fb: FormBuilder,
    public customerService: CustomerService,
    public router: Router,
    private activatedRoute: ActivatedRoute,
  ) { }

  ngOnInit(): void {
    this.formEditCustomer = this.fb.group({
      customerType: ['', [Validators.required ]],
      fullName: ['', [Validators.required ]],
      dayOfBirth: ['', [Validators.required, this.checkDateOfBirth]],
      idCard: ['', [Validators.required, Validators.pattern('[0-9]{9}')]],
      phone: ['', [Validators.required, Validators.pattern('^(0|\\+84)(\\s|\\.)?((3[2-9])|(5[689])|(7[06-9])|(8[1-689])|(9[0-46-9]))(\\d)(\\s|\\.)?(\\d{3})(\\s|\\.)?(\\d{3})$')]],
      email: ['', [Validators.required, Validators.pattern('[a-z0-9_]+[a-z0-9]@([a-z0-9]+\\.)[a-z]+(|\\.[a-z]+)')]],
      address: ['', [Validators.required, ]]
    });
    this.activatedRoute.params.subscribe(data => {
      this.customerId = data.id;
      this.customerService.getCustomerById(this.customerId).subscribe(item => {
        this.formEditCustomer.patchValue(item);
      });
    });
  }
  checkDateOfBirth(absControl: AbstractControl): any {
    const value = absControl.value; // 2021-02-24
    const year = Number(value.substr(0, 4));

    return new Date().getFullYear() - year >= 18 ? null : {AgeGreaterThan18: true};
  }

  editCustomer() {
    this.customerService.editCustomer(this.formEditCustomer.value, this.customerId)
      .subscribe(data => {
        this.router.navigateByUrl('customer-list');
      });
  }

}
