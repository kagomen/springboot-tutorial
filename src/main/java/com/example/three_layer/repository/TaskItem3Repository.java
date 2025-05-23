package com.example.three_layer.repository;

import com.example.three_layer.entity.TaskItem3;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // DBを扱うインターフェースであることをSpringに伝える
public interface TaskItem3Repository extends JpaRepository<TaskItem3, Integer> {}
