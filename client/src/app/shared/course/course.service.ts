import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

import 'rxjs/add/operator/map';
import { Course } from '../../models/course.model';
@Injectable()
export class CourseService {
  private serviceUrl1 = '//localhost:3333/listCourse';
  constructor(private http: HttpClient)
  {}
  getCourse(): Observable<Course[]> {
    return this.http.get<Course[]>(this.serviceUrl1);
  }
}
