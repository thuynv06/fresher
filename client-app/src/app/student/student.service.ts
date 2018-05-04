import { Injectable } from '@angular/core';
import { Http, Response } from "@angular/http";
import 'rxjs/add/operator/map'
import 'rxjs/add/operator/catch';
import { Observable } from "rxjs/Observable";
import {Student} from "./Student";
@Injectable()
export class StudentService {
  private apiUrl=  '//localhost:3333/student';
  constructor(private http: Http) { }
  findAll():Observable<Student[]>{
    return this.http.get(this.apiUrl)
       .map((res:Response) => res.json())
       .catch((error:any) => Observable.throw(error.json().error || 'Server error'));
  }
  findById(id:number):Observable<Student>{
    return this.http.get(this.apiUrl + '/' + id)
        .map((res:Response) => res.json())
        .catch((error:any) => Observable.throw(error.json().error || 'Error'));
  }
  saveStudent(student: Student): Observable<Student> {
    console.log(this.apiUrl);
    return this.http.post(this.apiUrl, student)
       .catch((error:any) => Observable.throw(error.json().error || 'Server error'));
  }

  deleteStudentById(id: number): Observable<boolean> {
    return this.http.delete(this.apiUrl + '/' + id)
      .map((res:Response) => res.json())
      .catch((error:any) => Observable.throw(error.json().error || 'Server error'));
  }

  updateStudent(student: Student): Observable<Student> {
    return this.http.put(this.apiUrl, student)
      .map((res:Response) => res.json())
      .catch((error:any) => Observable.throw(error.json().error || 'Server error'));
  }
  getStudentListOfCourse(idCourse:number):Observable<Student[]>{
    return this.http.get(this.apiUrl + '/course-student/'+ idCourse)
    .map((res:Response) => res.json())
    .catch((error:any) => Observable.throw(error.json().error || 'Error'));
  }
}
