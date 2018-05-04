import { Injectable } from '@angular/core';
import { Http, Response } from "@angular/http";
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map'
import 'rxjs/add/operator/catch';
import { Student } from '../../models/student.model';
@Injectable()
export class StudentService {
 private serviceUrl = '//localhost:3333/student';
 constructor(private http: Http) {
  }

  getStudent(): Observable<Student[]> {
    return this.http.get(this.serviceUrl)
       .map((res:Response) => res.json())
       .catch((error:any) => Observable.throw(error.json().error || 'Server error'));
  }
  findById(id:number):Observable<Student>{
    return this.http.get(this.serviceUrl + '/' + id)
        .map((res:Response) => res.json())
        .catch((error:any) => Observable.throw(error.json().error || 'Error'));
  }
}
