import { Component, OnInit } from '@angular/core';
import { StudentService} from '../shared/students/student.service';
import { Observable } from 'rxjs/Observable';
import {DataSource} from '@angular/cdk/collections';
import { Student } from '../models/student.model';
import {ActivatedRoute,Router } from '@angular/router';

@Component({
  selector: 'app-student-list',
  templateUrl: './student-list.component.html',
  styleUrls: ['./student-list.component.css']
})
export class StudentListComponent implements OnInit {

  dataSource = new StudentDataSource(this.studentService);
  displayedColumns = ['name','age', 'address', 'phone','Choose'];
  constructor(
      private studentService: StudentService,
      private router: Router,
      private route: ActivatedRoute) { }
  ngOnInit() {
  }

  viewProfileStudent(student: Student){
    this.router.navigate(['/student-view/'+ student.idStudent])
  }
  viewCourse(student: Student){
    this.router.navigate(['/take-course/' + student.idStudent]);
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
