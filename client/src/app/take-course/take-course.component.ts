import { Component, OnInit } from '@angular/core';
import { CourseService} from '../shared/course/course.service';
import { StudentService } from '../shared/students/student.service';
import { Observable } from 'rxjs/Observable';
import {DataSource} from '@angular/cdk/collections';
import { Course } from '../models/course.model';
import { Student} from '../models/student.model';
import {ActivatedRoute, Router} from '@angular/router';
 
@Component({
  selector: 'app-take-course',
  templateUrl: './take-course.component.html',
  styleUrls: ['./take-course.component.css']
})
export class TakeCourseComponent implements OnInit {
  dataSource = new CourseDataSource(this.courseService);
  displayedColumns = ['idCourse','name','price','check'];
  private student : Student;
  private idStudent: number;
  constructor(
    private router:Router,
    private route: ActivatedRoute,
    private courseService: CourseService,
    private studentService: StudentService) { }
  ngOnInit() {
    this.sub= this.route.params.subscribe( params =>{
      this.idStudent = params ['id'];
      if(this.idStudent){
        this.studentService.findById(this.idStudent).subscribe(
          student =>{
            this.student =student;
          },error =>{console.log(error)}
        );
      }

  })
}
export class CourseDataSource extends DataSource<any>{
  constructor(private courseService: CourseService){
    super();
  }
  connect(): Observable<Course[]>{
    return this.courseService.getCourse();
  }
  disconnect(){};
}
