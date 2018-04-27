import { Component, OnInit } from '@angular/core';
import { StudentService } from "../student.service";
import { Student } from "../Student";
import {ActivatedRoute, Router} from '@angular/router';
import {Course} from '../../course/Course'
// import {Course} from ".../course/Course";
@Component({
  selector: 'app-student-list',
  templateUrl: './student-list.component.html',
  styleUrls: ['./student-list.component.css'],
  providers: [StudentService]
})
export class StudentListComponent implements OnInit {
  private students: Student[];
  private courses: Course[];
  idCourse :number;
  private sub:any;
//  private courses: Course[];
  constructor(private router:Router,
    private route: ActivatedRoute,
  private studentService: StudentService) {
   }

  ngOnInit() {
    this.getAllStudent();
    this.sub= this.route.params.subscribe( params =>{
      this.idCourse = params ['id'];

      if(this.idCourse){// get studen list of course
        this.studentService.getStudentListOfCourse(this.idCourse).subscribe(
          students =>{
            this.students = students;
          },error =>{console.log(error)}
        );
      }else{
        this.getAllStudent();
      }

    })
  }
  getAllStudent(){
    this.studentService.findAll().subscribe(
      students =>{
        this.students = students;
      },
      error =>{
        console.log(error);
      }
    );
  }
  redirectNewStudentPage(){
    this.router.navigate (['/student/create']);
  }
  editStudentPage(student:Student){
    if(student){
      this.router.navigate(['/student/edit',student.idStudent]);
    }
  }
  deleteStudent(student:Student){
    if (student) {
      this.studentService.deleteStudentById(student.idStudent).subscribe(
        res => {
          this.getAllStudent();
          this.router.navigate(['/student']);
          console.log('done');
        }
      );
    }
  }
  getStudentCourse(student:Student){
    console.log (this.router);
    this.router.navigate(['/course/student-course/'+ student.idStudent]);
  }
}
