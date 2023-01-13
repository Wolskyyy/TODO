package com.kamil.todo.dao;

import com.kamil.todo.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Repository extends JpaRepository<Task, Integer> {
    List<Task> findById(int id);
}
