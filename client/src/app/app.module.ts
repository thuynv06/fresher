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
import { StudentService } from './student.service';
import { StudentListComponent } from './student-list/student-list.component';


@NgModule({
  declarations: [
    AppComponent,
    CarListComponent,
    StudentListComponent
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
    MatProgressSpinnerModule
  ],
  providers: [CarService,GiphyService,StudentService],
  bootstrap: [AppComponent]
})
export class AppModule { }
