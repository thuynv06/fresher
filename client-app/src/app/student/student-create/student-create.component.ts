import { Component,OnDestroy, OnInit,Input } from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import { StudentService } from "../student.service";
import { Student } from "../Student";
import {ActivatedRoute, Router} from '@angular/router';
@Component({
  selector: 'app-student-create',
  templateUrl: './student-create.component.html',
  styleUrls: ['./student-create.component.css'],
  providers: [StudentService]
})
export class StudentCreateComponent implements OnInit,OnDestroy {
  idStudent: number;
  student:Student;
  studentForm :FormGroup;
  @Input() name: String;
  @Input() age: number;
  private sub: any;
  constructor(
    private route: ActivatedRoute,
    private router:Router,
    private studentService:StudentService
    ) { }

  ngOnInit() {
    // this.sub = this.route.params.subscribe( params =>{
    //   this.idStudent = params['id'];
    // })
    // this.studentForm = new FormGroup({
    //   name: new FormControl('',Validators.required),
    //   age: new FormControl('',Validators.required),
    //   address: new FormControl('',Validators.required),
    //   phone: new FormControl('',Validators.required)
    // });
    // // edit student
    // if(this.idStudent){
    //   this.studentService.findById(this.idStudent).subscribe(
    //     student =>{
    //       this.idStudent = student.idStudent,
    //       this.studentForm.patchValue({
    //         name: student.name,
    //         age: student.age,
    //         address: student.address,
    //         phone: student.phone
    //       });
    //     },error => { console.log(error);
    //     }
    //   );
    // }
  }

  ngOnDestroy():void {
    this.sub.unsubscribe();
  }
  // onSubmit(){
  //   if(this.studentForm.valid){
  //     if(this.idStudent){
  //       let student: Student= new Student(this.idStudent,
  //         this.studentForm.controls['name'].value,
  //         this.studentForm.controls['age'].value,
  //         this.studentForm.controls['address'].value,
  //         this.studentForm.controls['phone'].value);
  //         this.studentService.updateStudent(student).subscribe();
  //     }else {
  //       let student: Student = new Student(null,
  //       this.studentForm.controls['name'].value,
  //       this.studentForm.controls['age'].value,
  //       this.studentForm.controls['address'].value,
  //       this.studentForm.controls['phone'].value);
  //       this.studentService.saveStudent(student).subscribe();
  //     }
  //
  //   }
  //   this.studentForm.reset();
  //   this.router.navigate(['/student']);
  // }
  // redirectStudentPage(){
  //   this.router.navigate(['/student']);
  // }
}
