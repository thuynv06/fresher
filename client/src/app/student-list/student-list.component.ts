import { Component, OnInit } from '@angular/core';
import { StudentService} from '../shared/students/student.service';
import { Observable } from 'rxjs/Observable';
import {DataSource} from '@angular/cdk/collections';
import { Student } from '../models/student.model';
@Component({
  selector: 'app-student-list',
  templateUrl: './student-list.component.html',
  styleUrls: ['./student-list.component.css']
})
export class StudentListComponent implements OnInit {
  dataSource = new StudentDataSource(this.studentService);
  displayedColumns = ['name','age', 'address', 'phone'];
  constructor(private studentService: StudentService) { }
  ngOnInit() {
  }
}
export class StudentDataSource extends DataSource<any> {
  constructor(private studentService: StudentService) {
    super();
  }
  connect(): Observable<Student[]> {
    return this.studentService.getStudent();
  }
  disconnect() {};
}
