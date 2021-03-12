import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';
import {EmployeeService} from '../../../services/employee.service';
import {Router} from '@angular/router';
import {AngularFireStorage} from '@angular/fire/storage';
import {finalize} from 'rxjs/operators';

@Component({
  selector: 'app-employee-create',
  templateUrl: './employee-create.component.html',
  styleUrls: ['./employee-create.component.css']
})
export class EmployeeCreateComponent implements OnInit {
  public formCreateEmployee: FormGroup;
  imgSrc = '/assets/img/images.jpg';
  selectedImage: any = null;

  constructor(
    public fb: FormBuilder,
    public employeeService: EmployeeService,
    public router: Router,
    private storage: AngularFireStorage
  ) { }

  ngOnInit(): void {
    this.formCreateEmployee = this.fb.group({
      firstName: new FormControl('', [Validators.required]),
      lastName: new FormControl('', [Validators.required]),
      email: new FormControl('', [Validators.required]),
      image: new FormControl('', [Validators.required]),
    });
  }
  addNewEmployee(formValue){
    const filePath = `images/${this.selectedImage.name.split('.').slice(0, -1).join('.')}_${new Date().getTime()}`;
    const fileRef = this.storage.ref(filePath);
    this.storage.upload(filePath, this.selectedImage).snapshotChanges().pipe(
      finalize(() => {
        fileRef.getDownloadURL().subscribe((url) => {
          formValue.image = url;
          this.employeeService.addNewEmployee(formValue).subscribe(data => {
            this.router.navigateByUrl('employee-list');
          });
        });
      } )
    ).subscribe();
  }

  showPreview(event: any){
    if (event.target.files && event.target.files[0]){
      const reader = new FileReader();
      reader.onload = (e: any) => this.imgSrc = e.target.result;
      reader.readAsDataURL(event.target.files[0]);
      this.selectedImage = event.target.files[0];
    } else {
      this.imgSrc = '/assets/img/images.jpg';
      this.selectedImage = null;
    }
  }
}
