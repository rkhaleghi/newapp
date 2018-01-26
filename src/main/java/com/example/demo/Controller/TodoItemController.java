/**
 *
 */
package com.example.demo.Controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.TodoItem;
import com.example.demo.service.TodoService;

@CrossOrigin("*")
@RestController
public class TodoItemController
{

	@Autowired
	TodoService service;
	public List<TodoItem> todos = new ArrayList<>();

	public TodoItemController() throws ParseException
	{
		this.todos = createTodos();
	}

	@RequestMapping(value = "/todos", method = RequestMethod.GET)
	public List<TodoItem> getAllTodo()
	{
//		 return service.findAll();
//		System.out.println(SecurityContextHolder.getContext().getAuthentication().getPrincipal());
//		UserInfo user = (UserInfo) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//		System.out.println(user.getEmail());
//		System.out.println(user.getGender());
//		System.out.println(user.getPicture());
		return this.todos;
	}

	@RequestMapping(value="/todos/{id}", method=RequestMethod.GET)
	public TodoItem findSingleTodo(@PathVariable("id") long id){
		return null;
	}

	@RequestMapping(value="/create", method= RequestMethod.POST)
	public TodoItem save(@RequestBody TodoItem item ) throws ParseException {
//		return service.save(item);

//		createTodos().forEach(todo -> {
//			service.save(todo);
//		});

		return null;
	}



	public static List<TodoItem> createTodos() throws ParseException
	{
		SimpleDateFormat format = new SimpleDateFormat("MM-dd-yyyy");
		Date date = new Date();

		List<TodoItem> todos = new ArrayList<>();
		TodoItem t1 = new TodoItem("description1", "London", format.parse("12-11-1989"));
		TodoItem t2 = new TodoItem("description2", "London", format.parse("12-11-1989"));
		TodoItem t3 = new TodoItem("description3", "London", format.parse("12-11-1989"));
		TodoItem t4 = new TodoItem("description4", "London", format.parse("12-11-1989"));
		todos.add(t1);
		todos.add(t2);
		todos.add(t3);
		todos.add(t4);
		return todos;
	}


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