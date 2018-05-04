import { Component, OnInit } from '@angular/core';
import { CourseService} from '../shared/course/course.service';
import { Observable } from 'rxjs/Observable';
import {DataSource} from '@angular/cdk/collections';
import { Course } from '../models/course.model';
@Component({
  selector: 'app-take-course',
  templateUrl: './take-course.component.html',
  styleUrls: ['./take-course.component.css']
})
export class TakeCourseComponent implements OnInit {
  dataSource = new CourseDataSource(this.courseService);
  displayedColumns = ['idCourse','name','price','check'];

  constructor(private courseService: CourseService) { }
  ngOnInit() {
  }
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
