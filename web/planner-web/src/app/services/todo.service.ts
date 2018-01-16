import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs/Observable';
import 'rxjs/add/operator/map';
import {TodoItems} from '../models/todo-item';

@Injectable()
export class TodoService {

 private baseUrl = 'http://localhost:8080/';
 private getUrl = this.baseUrl + 'todos';

  constructor(private http: HttpClient) { }

  getAllTodos(): Observable<Object> {
    return this.http.get(this.getUrl);
  }

}
