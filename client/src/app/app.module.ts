import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { MatButtonModule, MatCardModule, MatInputModule, MatListModule, MatToolbarModule } from '@angular/material';
import {  MatPaginatorModule, MatProgressSpinnerModule,
         MatSortModule, MatTableModule } from "@angular/material";
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { GiphyService } from './shared/giphy/giphy.service';
import { AppComponent } from './app.component';
import { CarService } from './car.service';
import { CarListComponent } from './car-list/car-list.component';
import { StudentService } from './shared/students/student.service';
import { StudentListComponent } from './student-list/student-list.component';
import { CourseService } from './shared/course/course.service';
import { CourseListComponent } from './course-list/course-list.component';
import { CarEditComponent } from './car-edit/car-edit.component';
import { FormsModule } from '@angular/forms';
import { RouterModule, Routes } from '@angular/router';

const appRoutes:Routes=[
  {path:'',redirectTo:'/car-list',pathMatch:'full'},
  {
    path:'car-list',
    component:CarListComponent
  },
  {
    path:'car-add',
    component:CarEditComponent
  },
  {
    path:'car-edit/:id',
    component:CarEditComponent
  }
];
@NgModule({
  declarations: [
    AppComponent,
    CarListComponent,
    StudentListComponent,
    CourseListComponent,
    CarEditComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MatButtonModule,
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
  providers: [CarService,GiphyService,StudentService,CourseService],
  bootstrap: [AppComponent]
})
export class AppModule { }
