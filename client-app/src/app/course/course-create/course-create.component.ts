import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {CourseService} from "../course.service";
import {Course} from "../Course";
import {ActivatedRoute, Router} from '@angular/router';
@Component({
  selector: 'app-course-create',
  templateUrl: './course-create.component.html',
  styleUrls: ['./course-create.component.css'],
  providers: [CourseService]
})
export class CourseCreateComponent implements OnInit {
  idCourse : number;
  course: Course;
  courseForm: FormGroup;
  private sub: any;
  constructor(private route: ActivatedRoute,
              private router: Router,
              private courseService: CourseService) { }

  ngOnInit() {

    this.sub = this.route.params.subscribe(params => {
     this.idCourse = params['id'];
    });

    this.courseForm = new FormGroup({
      name: new FormControl('', Validators.required),
      price: new FormControl('', Validators.required),
    });
    if (this.idCourse) { //edit form
      this.courseService.findById(this.idCourse).subscribe(
        course=> {
            this.idCourse = course.idCourse;
            this.courseForm.patchValue({
            name: course.name,
            price: course.price,
          });
         },error => {
          console.log(error);
         }
      );
    }
  }
  ngOnDestroy(): void {
    this.sub.unsubscribe();
  }

  onSubmit() {
    if (this.courseForm.valid) {
        let course: Course = new Course(null,
        this.courseForm.controls['name'].value,
        this.courseForm.controls['price'].value,);
        this.courseService.saveCourse(course).subscribe();
     }
      this.courseForm.reset();
      this.router.navigate(['/course']);
  }
  redirectCoursePage() {
    this.router.navigate(['/course']);
  }
}
