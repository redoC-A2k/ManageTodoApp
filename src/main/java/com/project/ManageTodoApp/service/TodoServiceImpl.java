package com.project.ManageTodoApp.service;

import org.springframework.stereotype.Service;

import com.project.ManageTodoApp.dto.TodoDto;
import com.project.ManageTodoApp.entity.Todo;
import com.project.ManageTodoApp.exception.ResourceNotFoundException;
import com.project.ManageTodoApp.mapper.TodoMapper;
import com.project.ManageTodoApp.repository.TodoRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TodoServiceImpl implements TodoService {

    private final TodoRepository todoRepository;

    @Override
    public Todo createTodo(TodoDto todoDto) {
        Todo todo = TodoMapper.mapTododtoToEntity(todoDto);
        return todoRepository.save(todo);
    }

    @Override
    public void deleteTodoById(Long id) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Todo not found with id : " + id));
        todoRepository.delete(todo);
    }

    @Override
    public Todo getTodoById(Long id) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Todo not found with id : " + id));
        return todo;
    }

    @Override
    public TodoDto updateTodo(Long id, TodoDto todoDto) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Todo not found with id : " + id));
        if (todoDto.getId() == todo.getId()) {
            todo.setTitle(todoDto.getTitle());
            todo.setDescription(todoDto.getDescription());
            todoRepository.save(todo);
        } else throw new ResourceNotFoundException("Todo not found with id : " + id);
        return null;
    }

}