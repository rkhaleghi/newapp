import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs/Observable';
import 'rxjs/add/operator/map';
import {TodoItems} from '../models/todo-item';
import { User } from '../models/user';
import { Subscription } from 'rxjs/Subscription';

@Injectable()
export class TodoService {

 private baseUrl = 'http://localhost:8080/api/v1/';
 private getUrl = 'http://localhost:8080/api/v1/todos';
   // this.baseUrl + 'todos';
 private getlogin = this.baseUrl + 'login';

  constructor(private http: HttpClient) { }

  user: User;
  getAllTodos(): Observable<Object> {
    return this.http.get(this.getUrl);
  }

  getuserInfo(): Subscription {
    // return this.http.get(this.getlogin);
    return this.http.get(this.getlogin).subscribe(res => console.log(res));
  }

}
