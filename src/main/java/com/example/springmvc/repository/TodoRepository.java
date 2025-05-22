package com.example.springmvc.repository;

import com.example.springmvc.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

// JpaRepository<エンティティの型, IDの型>
public interface TodoRepository extends JpaRepository<Todo, Integer> {}

// JpaRepositoryクラスを継承したインターフェースを作成するだけで、
// findAll(), findById(), save(), deleteById()といったメソッドが使えるようになる
