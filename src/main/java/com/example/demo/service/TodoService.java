/**
 *
 */
package com.example.demo.service;

import java.util.List;

import com.example.demo.model.TodoItem;

/**
 * @author RezaKhaleghi
 *
 */
public interface TodoService
{

	public List<TodoItem> findAll();

	public TodoItem save(TodoItem todoItem);

	public void deleteTodoItemById(Long id);

	public void deleteAllTodoItems();

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