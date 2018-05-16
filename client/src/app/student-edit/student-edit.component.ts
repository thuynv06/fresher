import { Component, OnInit,OnDestroy,Input } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import { StudentService} from '../shared/students/student.service';
import { Student } from '../models/student.model';
import {FormControl, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-student-edit',
  templateUrl: './student-edit.component.html',
  styleUrls: ['./student-edit.component.css']
})
export class StudentEditComponent implements OnInit,OnDestroy {
  idStudent: number;
  student:Student;
  studentForm :FormGroup;
  @Input() name: string;
  @Input() age: number;
  @Input() address: string;
  private sub: any;
  constructor(
    private route: ActivatedRoute,
    private router:Router,
    private studentService:StudentService
    ) { }
  ngOnInit() {
    this.sub = this.route.params.subscribe( params =>{
      this.idStudent = params['id'];
    })
    this.studentForm = new FormGroup({
      name: new FormControl('',Validators.required),
      age: new FormControl('',Validators.required),
      address: new FormControl('',Validators.required),
      phone: new FormControl('',Validators.required)
    });
    if(this.idStudent){
      this.studentService.findById(this.idStudent).subscribe(
        student =>{
          this.idStudent = student.idStudent,
          this.studentForm.patchValue({
            name: student.name,
            age: student.age,
            address: student.address,
            phone: student.phone
          });
        },error => { console.log(error);
        }
      );
    }

  }
  ngOnDestroy():void {
    this.sub.unsubscribe();
  }
  onSubmit(){}

}
