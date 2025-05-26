package com.example.three_layer.common;

import java.time.Instant;
import lombok.Data;
import org.springframework.data.domain.Page;

@Data
public class Meta {
  private final Instant timestamp;
  private final int page; // 今何ページか
  private final int size; // 1ページあたり何件取得するか
  private final long totalElements; // 総件数
  private final int totalPages; // 全ページ数

  public static Meta now() {
    return new Meta(Instant.now(), 0, 0, 0, 0);
  }

  public static Meta fromPage(Page<?> page) {
    return new Meta(
        Instant.now(),
        page.getNumber(),
        page.getSize(),
        page.getTotalElements(),
        page.getTotalPages());
  }

  private Meta(Instant timestamp, int page, int size, long totalElements, int totalPages) {
    this.timestamp = timestamp;
    this.page = page;
    this.size = size;
    this.totalElements = totalElements;
    this.totalPages = totalPages;
  }
}
