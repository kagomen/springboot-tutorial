package com.example.springmvc.controller;

import com.example.springmvc.model.Todo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Todo API")
@RestController // 自動でJSONにパースして返す
@RequestMapping("/todos")
public class TodoController {

  private final Map<Integer, Todo> todos = new HashMap<>();
  private int nextId = 1;

  @Operation(summary = "Todo一覧取得")
  @GetMapping
  public Collection<Todo> getTodos() {
    return todos.values();
  }

  @Operation(summary = "Todo追加")
  @PostMapping
  public Todo addTodo(@RequestBody Todo todo) { // JSONが自動でパースされ、オブジェクトとして受け取る
    todo.setId(nextId++);
    todos.put(todo.getId(), todo);
    return todo;
  }

  @Operation(summary = "Todo削除")
  @DeleteMapping("/{id}")
  public void deleteTodo(@PathVariable Integer id) {
    todos.remove(id);
  }
}
