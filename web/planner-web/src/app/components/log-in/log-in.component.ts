import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-log-in',
  templateUrl: './log-in.component.html',
  styleUrls: ['./log-in.component.css']
})
export class LogInComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }
 public logout(){
   console.log('log out');
   document.location.href= "https://mail.google.com/mail/u/0/?logout&hl=en";
 }
}
