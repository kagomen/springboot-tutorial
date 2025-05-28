package com.example.three_layer.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.three_layer.dto.TaskItem3PatchRequest;
import com.example.three_layer.dto.TaskItem3Request;
import com.example.three_layer.dto.TaskItem3UpdateRequest;
import com.example.three_layer.entity.TaskItem3;
import com.example.three_layer.exception.TaskItem3NotFoundException;
import com.example.three_layer.mapper.TaskItem3Mapper;
import com.example.three_layer.repository.TaskItem3Repository;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class) // MockitoをJUnitで使う場合必須
public class TaskItem3ServiceImplTest {

  @Mock TaskItem3Repository repo;

  @Mock TaskItem3Mapper mapper;

  @InjectMocks TaskItem3ServiceImpl service;

  @Test
  void save_タスクを登録できる() {
    Integer id = 1;
    // リクエストDTO
    var req = new TaskItem3Request();
    req.setTitle("買い物");
    req.setDone(false);

    // toEntity()の戻り値
    var entity = new TaskItem3();
    entity.setTitle("買い物");
    entity.setDone(false);

    // repo.save()の戻り値
    var savedEntity = new TaskItem3();
    savedEntity.setId(id);
    savedEntity.setTitle("買い物");
    savedEntity.setDone(false);

    when(mapper.toEntity(req)).thenReturn(entity); // mapperの振る舞いを定義
    when(repo.save(entity)).thenReturn(savedEntity); // repositoryの振る舞いを定義

    var actual = service.save(req);

    assertEquals(id, actual.getId());
    assertEquals("買い物", actual.getTitle());
    assertFalse(actual.isDone());

    verify(mapper).toEntity(req); // mapper.toEntity(req)が実行されたかの確認
    verify(repo).save(entity); // repo.save(entity)が実行されたかの確認
  }

  @Test
  void update_タスクを更新できる() {
    Integer id = 1;
    // リクエストDTO
    var req = new TaskItem3UpdateRequest();
    req.setTitle("買い物");
    req.setDone(true);

    // DB登録済みのエンティティ
    var existing = new TaskItem3();
    existing.setId(id);
    existing.setTitle("買い物");
    existing.setDone(false);

    // repo.save()の戻り値
    var updated = new TaskItem3();
    updated.setId(id);
    updated.setTitle("買い物");
    updated.setDone(true);

    when(repo.findById(id)).thenReturn(Optional.of(existing));
    when(repo.save(existing)).thenReturn(updated);

    var actual = service.update(id, req);

    assertEquals(id, actual.getId());
    assertEquals("買い物", actual.getTitle());
    assertTrue(actual.isDone());

    verify(repo).findById(id);
    verify(repo).save(existing);
  }

  @Test
  void update_存在しないIDのタスクなら例外を投げる() {
    Integer notFoundId = 999;
    var req = new TaskItem3UpdateRequest();
    req.setTitle("買い物");
    req.setDone(true);

    when(repo.findById(notFoundId)).thenReturn(Optional.empty());

    assertThrows( // 第1引数の期待される例外クラスの型と、第2引数の関数が投げる例外の型が一致してるかを検証する
        TaskItem3NotFoundException.class,
        () -> {
          service.update(notFoundId, req);
        });

    verify(repo).findById(notFoundId);
  }

  @Test
  void partialUpdate_部分的にタスクを更新できる() {
    Integer id = 1;
    var req = new TaskItem3PatchRequest();
    req.setTitle("イオンで買い物");
    req.setDone(null);

    var existing = new TaskItem3();
    existing.setId(id);
    existing.setTitle("買い物");
    existing.setDone(false);

    var updated = new TaskItem3();
    updated.setId(id);
    updated.setTitle("イオンで買い物");
    updated.setDone(false);

    when(repo.findById(id)).thenReturn(Optional.of(existing));
    when(repo.save(existing)).thenReturn(updated);

    var actual = service.partialUpdate(id, req);

    assertEquals(id, actual.getId());
    assertEquals("イオンで買い物", actual.getTitle());
    assertFalse(actual.isDone());

    verify(repo).findById(id);
    verify(repo).save(existing);
  }

  @Test
  void partialUpdate_存在しないIDのタスクなら例外を投げる() {
    Integer notFoundId = 999;
    var req = new TaskItem3PatchRequest();
    req.setTitle("イオンで買い物");
    req.setDone(null);

    when(repo.findById(notFoundId)).thenReturn(Optional.empty());

    assertThrows(
        TaskItem3NotFoundException.class,
        () -> {
          service.partialUpdate(notFoundId, req);
        });

    verify(repo).findById(notFoundId);
  }

  @Test
  void deleteById_タスクを削除できる() {
    Integer id = 1;
    service.deleteById(id);

    verify(repo).deleteById(id);
  }
}
