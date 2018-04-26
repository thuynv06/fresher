import { Component, OnInit } from '@angular/core';
import {Course} from "../Course";
import {CourseService} from "../course.service";
import { Router } from '@angular/router';
@Component({
  selector: 'app-course-list',
  templateUrl: './course-list.component.html',
  styleUrls: ['./course-list.component.css'],
  providers: [CourseService]
})
export class CourseListComponent implements OnInit {
  private courses: Course[];
  constructor(
    private router: Router,
    private courseService : CourseService) { }

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
  redirectNewCoursePage(){
    this.router.navigate(['/course/create'])
  }
  editCoursePage(course :Course){
    if(course){
      this.router.navigate(['/course/edit',course.idCourse]);
    }
  }
  deleteCourse(c: Course) {
    if (c) {
     this.courseService.deleteCourseById(c.idCourse).subscribe(
       res => {
         this.getAllCourse();
         this.router.navigate(['/course']);
         console.log('done');
       }
     );
   }
  }

}
