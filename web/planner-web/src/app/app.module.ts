import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {MatTableModule} from '@angular/material/table';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import { AppComponent } from './app.component';
import {HttpClientModule} from '@angular/common/http';
import {TodoListComponent} from './components/todo-list/todo-list.component';
import { CreateTodoComponent } from './components/create-todo/create-todo.component';
import {MatInputModule} from '@angular/material/input';
import { AppRoutingModule } from './/app-routing.module';
import {NoopAnimationsModule} from '@angular/platform-browser/animations';
import { LogInComponent } from './components/log-in/log-in.component';

@NgModule({
  declarations: [
    AppComponent,
    TodoListComponent,
    CreateTodoComponent,
    LogInComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    MatTableModule,
    NgbModule.forRoot(),
    MatInputModule,
    AppRoutingModule,
    NoopAnimationsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
