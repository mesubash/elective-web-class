package io.github.subash.electiveclass.service;

import io.github.subash.electiveclass.dto.TodoRequest;
import io.github.subash.electiveclass.dto.TodoResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TodoService {
    TodoResponse create(TodoRequest request);
    TodoResponse getById(Long id);
    Page<TodoResponse> getAll(Pageable pageable);
    TodoResponse update(Long id, TodoRequest request);
    void delete(Long id);
    TodoResponse markComplete(Long id);
}

