package io.github.subash.electiveclass.service.impl;

import io.github.subash.electiveclass.dto.TodoRequest;
import io.github.subash.electiveclass.dto.TodoResponse;
import io.github.subash.electiveclass.exception.ResourceNotFoundException;
import io.github.subash.electiveclass.model.Todo;
import io.github.subash.electiveclass.repository.TodoRepository;
import io.github.subash.electiveclass.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService {

    private final TodoRepository todoRepository;

    @Override
    @Transactional
    public TodoResponse create(TodoRequest request) {
        Todo todo = new Todo();
        todo.setTitle(request.getTitle());
        todo.setDescription(request.getDescription());
        if (request.getPriority() != null) {
            todo.setPriority(request.getPriority());
        }
        Todo saved = todoRepository.save(todo);
        return toResponse(saved);
    }

    @Override
    public TodoResponse getById(Long id) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Todo not found with id: " + id));
        return toResponse(todo);
    }

    @Override
    public Page<TodoResponse> getAll(Pageable pageable) {
        return todoRepository.findAll(pageable).map(this::toResponse);
    }

    @Override
    @Transactional
    public TodoResponse update(Long id, TodoRequest request) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Todo not found with id: " + id));
        todo.setTitle(request.getTitle());
        todo.setDescription(request.getDescription());
        if (request.getPriority() != null) {
            todo.setPriority(request.getPriority());
        }
        return toResponse(todoRepository.save(todo));
    }

    @Override
    @Transactional
    public void delete(Long id) {
        if (!todoRepository.existsById(id)) {
            throw new ResourceNotFoundException("Todo not found with id: " + id);
        }
        todoRepository.deleteById(id);
    }

    @Override
    @Transactional
    public TodoResponse markComplete(Long id) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Todo not found with id: " + id));
        todo.setCompleted(true);
        return toResponse(todoRepository.save(todo));
    }

    private TodoResponse toResponse(Todo todo) {
        return TodoResponse.builder()
                .id(todo.getId())
                .title(todo.getTitle())
                .description(todo.getDescription())
                .completed(todo.isCompleted())
                .priority(todo.getPriority())
                .createdAt(todo.getCreatedAt())
                .updatedAt(todo.getUpdatedAt())
                .build();
    }
}