import { Injectable } from '@angular/core';
import {Employee} from './employee';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  constructor() { }

  // get data from API
  findById(employeeId: number): Employee {
    const employeeList = new Array();
    employeeList.push(new Employee(12312, 'Nguyen Van A', '2001-02-23', 1));
    employeeList.push(new Student(6546, 'Nguyen Thi D', '2002-02-24', 0));
    employeeList.push(new Student(2343, 'Nguyen Thi B', '2003-02-25', 0));
    employeeList.push(new Student(7776, 'Nguyen Van C', '2004-02-26', 1));

    return employeeList.find(studentObj => studentObj.id === employeeId);
  }
}
