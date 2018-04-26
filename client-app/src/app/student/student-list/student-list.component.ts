import { Component, OnInit } from '@angular/core';
import { StudentService } from "../student.service";
import { Student } from "../Student";
import { Router} from '@angular/router';
import {Course} from ".../course/Course";
@Component({
  selector: 'app-student-list',
  templateUrl: './student-list.component.html',
  styleUrls: ['./student-list.component.css'],
  providers: [StudentService]
})
export class StudentListComponent implements OnInit {
  private students: Student[];
  private courses: Course[];
  constructor(private router:Router,
  private studentService: StudentService) {
   }

  ngOnInit() {
    this.getAllStudent();
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

  getCourse(student:Student){
    this.studentService.getCourse(student.idStudent).subscribe(
      courses=>{
        this.courses = courses;
      },error =>{
        console.log(error);
      }
    );
    this.router.navigate(['/student/course']);
  }
}
