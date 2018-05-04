import { Component, OnInit } from '@angular/core';
import {Course} from './../course/Course';
import {CourseService} from "./../course/course.service";
@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
  providers: [CourseService]
})
export class HomeComponent implements OnInit {
  private courses: Course[];
  constructor(
    private courseService : CourseService ,
  ) { }

  ngOnInit() {
    this.getAllCourse();
  }
  getAllCourse(){
    this.courseService.findAll().subscribe(
      courses =>{
        this.courses = courses;
      },error=>{
        console.log(error)}
    );
}
}
