import { Injectable } from '@angular/core';
import { Http, Response } from "@angular/http";
import 'rxjs/add/operator/map'
import 'rxjs/add/operator/catch';
import { Observable } from "rxjs/Observable";
import {Course} from './Course';
@Injectable()
export class CourseService {
  private apiUrl= '//localhost:3333/courses';

  constructor(private http: Http) {
   }
   findAll(): Observable<Course[]>{
     return this.http.get(this.apiUrl)
      .map((res:Response) => res.json())
      .catch((error:any) => Observable.throw(error.json().error || 'Server error'));
   }
   findById(idCourse:number):Observable<Course>{
     console.log(this.apiUrl + '/' + idCourse);
     return this.http.get(this.apiUrl + '/' + idCourse)
       .map((res:Response) => res.json())
       .catch((error:any) => Observable.throw(error.json().error || 'Error'));
     }
   saveCourse(course: Course): Observable<Course> {
     return this.http.post(this.apiUrl, course)
        .catch((error:any) => Observable.throw(error.json().error || 'Server error'));
     }

     deleteCourseById(idCourse: number): Observable<boolean> {
       return this.http.delete(this.apiUrl + '/' + idCourse)
     .map((res:Response) => res.json())
     .catch((error:any) => Observable.throw(error.json().error || 'Server error'));
     }

     updateCourse(course: Course): Observable<Course> {
       return this.http.put(this.apiUrl, course)
      .map((res:Response) => res.json())
      .catch((error:any) => Observable.throw(error.json().error || 'Server error'));
     }
}
