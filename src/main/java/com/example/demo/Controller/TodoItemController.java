/**
 *
 */
package com.example.demo.Controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.TodoItem;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class TodoItemController
{

	public List<TodoItem> todos = new ArrayList<>();

	public TodoItemController() throws ParseException{
		this.todos = createTodos();
	}



	 @RequestMapping(value = "/todos", method = RequestMethod.GET)
	    public List<TodoItem> getAllTodo(){
//	    return service.findAll();
	        return this.todos;
	    }

	  public static List<TodoItem> createTodos() throws ParseException{
		    SimpleDateFormat format = new SimpleDateFormat("MM-dd-yyyy");
		    Date date = new Date();





	        List<TodoItem> todos = new ArrayList<>();
	        TodoItem t1 = new TodoItem("description1", "London", format.parse("12-11-1989"));
	        TodoItem t2 = new TodoItem("description2", "London",format.parse("12-11-1989"));
	        TodoItem t3 = new TodoItem("description3", "London", format.parse("12-11-1989"));
	        TodoItem t4 = new TodoItem("description4", "London", format.parse("12-11-1989"));
	        todos.add(t1);
	        todos.add(t2);
	        todos.add(t3);
	        todos.add(t4);
	        return todos;
	    }

//	public List<User> user(){
//		List<User> user = new ArrayList<>();
//		User u1 =  new User(1L, "reza", "khaleghi", "reza@yahoo.com");
//		User u2 =  new User(1L, "reza", "khaleghi", "reza@yahoo.com");
//		User u3 =  new User(1L, "reza", "khaleghi", "reza@yahoo.com");
//
//		user.add(u1);
//		user.add(u2);
//		user.add(u3);
//		return user;
//	}

}

/* ---------------------------------------------------------------------*
 * This software is the confidential and proprietary
 * information of Lhasa Limited
 * Granary Wharf House, 2 Canal Wharf, Leeds, LS11 5PS
 * ---
 * No part of this confidential information shall be disclosed
 * and it shall be used only in accordance with the terms of a
 * written license agreement entered into by holder of the information
 * with LHASA Ltd.
 * --------------------------------------------------------------------- */