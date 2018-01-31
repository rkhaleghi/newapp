import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CreateTodoComponent } from './components/create-todo/create-todo.component';
import { TodoListComponent } from './components/todo-list/todo-list.component';
import { LogInComponent } from './components/log-in/log-in.component';

const routes: Routes = [
  {path: '', component: LogInComponent},
  {path: 'create', component: CreateTodoComponent},
  {path: 'api/v1/todos', component: TodoListComponent}
]

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
