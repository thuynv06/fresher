import { Injectable } from '@angular/core';
import { Http, Response } from "@angular/http";
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/map';
import { Course } from '../../models/course.model';
@Injectable()
export class CourseService {
  private serviceUrl = '//localhost:3333/courses';
  constructor(private http: Http)
  {}
  getCourse(): Observable<Course[]> {
    return this.http.get(this.serviceUrl)
       .map((res:Response) => res.json())
       .catch((error:any) => Observable.throw(error.json().error || 'Server error'));
  }
}
