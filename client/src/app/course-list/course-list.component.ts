import { Component, OnInit } from '@angular/core';
import { CourseService} from '../shared/course/course.service';
import { Observable } from 'rxjs/Observable';
import {DataSource} from '@angular/cdk/collections';
import { Course } from '../models/course.model';
@Component({
  selector: 'app-course-list',
  templateUrl: './course-list.component.html',
  styleUrls: ['./course-list.component.css']
})
export class CourseListComponent implements OnInit {
  dataSource = new CourseDataSource(this.courseService);
  displayedColumns = ['idCourse','name','price'];
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
