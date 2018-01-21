/**
 *
 */
package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.TodoItem;
import com.example.demo.repository.TodoRepository;

/**
 * @author RezaKhaleghi
 *
 */
@Service
public class TodoServiceImpl implements TodoService
{
	@Autowired
	TodoRepository repository;

	@Override
	public List<TodoItem> findAll()
	{
		return repository.findAll();
	}

	@Override
	public TodoItem save(TodoItem todoItem)
	{
		return repository.save(todoItem);
	}

	@Override
	public void deleteTodoItemById(Long id)
	{
		repository.delete(id);
	}

	@Override
	public void deleteAllTodoItems()
	{
		repository.deleteAll();
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