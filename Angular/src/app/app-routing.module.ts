import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CreateStudentComponent } from './student/create-student/create-student.component';
import { StudentDetailComponent } from './student/student-detail/student-detail.component';
import { StudentListComponent } from './student/student-list/student-list.component';
import { UpdateStudentComponent } from './student/update-student/update-student.component';

const routes: Routes = [

  { path: '', redirectTo: 'student', pathMatch: 'full' },
  { path: 'students', component: StudentListComponent },
  { path: 'add-stdt', component: CreateStudentComponent },
  { path: 'update-stdt/:id', component: UpdateStudentComponent },
  { path: 'stdt-detail/:id', component: StudentDetailComponent },

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
