import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpModule } from '@angular/http';
import { MatButtonModule, MatCardModule, MatInputModule, MatListModule, MatToolbarModule,MatCheckboxModule, } from '@angular/material';
import {  MatPaginatorModule, MatProgressSpinnerModule,
         MatSortModule, MatTableModule } from "@angular/material";
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { GiphyService } from './shared/giphy/giphy.service';
import { AppComponent } from './app.component';
//import { CarService } from './car.service';
//import { CarListComponent } from './car-list/car-list.component';
import { StudentService } from './shared/students/student.service';
import { StudentListComponent } from './student-list/student-list.component';
import { CourseService } from './shared/course/course.service';
import { CourseListComponent } from './course-list/course-list.component';
import { StudentEditComponent } from './student-edit/student-edit.component';
import { FormsModule } from '@angular/forms';
import { RouterModule, Routes } from '@angular/router';
import {  ReactiveFormsModule } from '@angular/forms';
import {TakeCourseComponent} from './take-course/take-course.component';
const appRoutes:Routes=[
  {path:'',redirectTo:'/student-list',pathMatch:'full'},
  {
    path:'student-list',
    component:StudentListComponent
  },
  {
    path:'course-list',
    component:CourseListComponent
  },
  {
    path:'take-course/:id',
    component:TakeCourseComponent
  },
  {
    path:'student-view/:id',
    component:StudentEditComponent
  }
];
@NgModule({
  declarations: [
    AppComponent,
    StudentListComponent,
    CourseListComponent,
    StudentEditComponent,
    TakeCourseComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    HttpModule,
    BrowserAnimationsModule,
    MatButtonModule,
    MatCheckboxModule,
    MatCardModule,
    MatListModule,
    MatToolbarModule,
    MatInputModule,
    MatTableModule,
    MatPaginatorModule,
    MatSortModule,
    MatProgressSpinnerModule,FormsModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [GiphyService,StudentService,CourseService],
  bootstrap: [AppComponent]
})
export class AppModule { }
