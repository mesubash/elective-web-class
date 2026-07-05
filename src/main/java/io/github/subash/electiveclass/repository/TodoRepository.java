package io.github.subash.electiveclass.repository;

import io.github.subash.electiveclass.model.Todo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {

    Page<Todo> findByCompleted(boolean completed, Pageable pageable);

    Page<Todo> findByTitleContainingIgnoreCase(String keyword, Pageable pageable);
}
