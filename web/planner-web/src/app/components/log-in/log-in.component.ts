import { Component, OnInit } from '@angular/core';
import { TodoService } from '../../services/todo.service';

@Component({
  selector: 'app-log-in',
  templateUrl: './log-in.component.html',
  styleUrls: ['./log-in.component.css'],
  providers: [TodoService]
})
export class LogInComponent implements OnInit {

  constructor(private _todoService: TodoService) { }

  ngOnInit() {
  }
 public logout() {
   console.log('log out');
   document.location.href= "https://mail.google.com/mail/u/0/?logout&hl=en";
 }
public login() {
  this._todoService.getuserInfo();
}

}
