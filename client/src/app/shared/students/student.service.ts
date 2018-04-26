import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

import 'rxjs/add/operator/map';
import { Student } from '../../models/student.model';
@Injectable()
export class StudentService {
 private serviceUrl = '//localhost:3333/students';
 constructor(private http: HttpClient) {
  }

  getStudent(): Observable<Student[]> {
    return this.http.get<Student[]>(this.serviceUrl);
  }
}
