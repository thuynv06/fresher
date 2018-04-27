import { Component, OnInit } from '@angular/core';
import {Course} from "../Course";
import {CourseService} from "../course.service";
import {ActivatedRoute, Router } from '@angular/router';
@Component({
  selector: 'app-course-list',
  templateUrl: './course-list.component.html',
  styleUrls: ['./course-list.component.css'],
  providers: [CourseService]
})
export class CourseListComponent implements OnInit {
  idStudent:number;
  private courses: Course[];
  private sub: any;
  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private courseService : CourseService ,

    ){}

  ngOnInit() {
    this.sub = this.route.params.subscribe( params =>{
      this.idStudent =params['id'];
    });
    if(this.idStudent){
      this.courseService.getStudentCourse(this.idStudent).subscribe(
        courses =>{
          this.courses=courses;
        },error =>{console.log(error)}
      );
    }else{
        this.getAllCourse();
    }

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
  getStudentListOfCourse(course: Course){
    console.log(this.route);
    this.router.navigate(['/student/StudentListOfCourse/'+ course.idCourse]);
  }
}
