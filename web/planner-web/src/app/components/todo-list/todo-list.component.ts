import { Component, OnInit } from '@angular/core';
import {TodoService} from '../../services/todo.service';
import {TodoItems} from '../../models/todo-item';
import {Observable} from 'rxjs/Observable';
import {MatTableDataSource} from '@angular/material';

@Component({
  selector: 'app-todo-list',
  templateUrl: './todo-list.component.html',
  styleUrls: ['./todo-list.component.css'],
  providers:[TodoService]
})
export class TodoListComponent implements OnInit {

  constructor(private todoService: TodoService) { }
  public todoItems: TodoItems[] = [];
  displayedColumns = ['description', 'location', 'date']
 public dataSource;


  ngOnInit() {
    this.getTodos();
  }

  public getTodos() {
  this.todoService.getAllTodos().subscribe((todos: TodoItems[]) => {
      this.todoItems = todos
      console.log(this.todoItems);
      this.dataSource = new MatTableDataSource<TodoItems>(this.todoItems);
    });

  }
}


