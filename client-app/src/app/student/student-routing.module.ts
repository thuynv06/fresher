import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { StudentListComponent} from './student-list/student-list.component';
import {StudentCreateComponent} from './student-create/student-create.component';
import {CourseListComponent} from '../course/course-list/course-list.component';

const routes: Routes = [
  {path:'student',component: StudentListComponent},
  {path:'student/create',component:StudentCreateComponent},
  {path:'student/edit/:id',component:StudentCreateComponent},
  {path:'student/StudentListOfCourse/:id',component:StudentListComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class StudentRoutingModule { }
