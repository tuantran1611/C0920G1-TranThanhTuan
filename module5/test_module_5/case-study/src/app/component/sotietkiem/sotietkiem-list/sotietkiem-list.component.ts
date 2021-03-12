import { Component, OnInit } from '@angular/core';
import {MatDialog} from '@angular/material/dialog';
import {EmployeeDeleteComponent} from '../../employees/employee-delete/employee-delete.component';
import {SotietkiemService} from '../../../services/sotietkiem.service';
import {SotietkiemDeleteComponent} from '../sotietkiem-delete/sotietkiem-delete.component';

@Component({
  selector: 'app-sotietkiem-list',
  templateUrl: './sotietkiem-list.component.html',
  styleUrls: ['./sotietkiem-list.component.css']
})
export class SotietkiemListComponent implements OnInit {

  public sotietkiems: any;
  term: string;
  p: number;
  private direction = 'asc';
  name: string;


  constructor(
    public sotietkiemService: SotietkiemService,
    public dialog: MatDialog
  ) { }

  ngOnInit(): void {
    this.sotietkiemService.laySos().subscribe(data => {
      this.sotietkiems = data;
    });
  }

  openDialog(idSo): void {
    this.sotietkiemService.laySoById(idSo).subscribe(dataSo => {
      const dialogRef = this.dialog.open(SotietkiemDeleteComponent, {
        width: '500px',
        data: { data1: dataSo },
        disableClose: true
      });

      dialogRef.afterClosed().subscribe(result => {
        console.log('The dialog was closed');
        this.ngOnInit();
      });
    });
  }

  sort(name: string){
    if (this.direction === 'asc'){
      this.direction = 'desc';
    }else {
      this.direction = 'asc';
    }
    this.sotietkiemService.sort(name, this.direction).subscribe(data => {
      this.sotietkiems = data;
    });
  }
  search(){
    this.sotietkiemService.searchByName(this.name).subscribe(data => {
      console.log(data);
      this.p = 0;
      this.sotietkiems = data;
    });
  }

}
