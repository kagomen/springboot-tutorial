package com.example.three_layer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Profile("dev")
@Configuration
public class SecurityConfigDev {

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http.authorizeHttpRequests(
            auth ->
                auth.requestMatchers(
                        "/swagger-ui/**", "/v3/api-docs/**", "/h2-console/**") // 認証無効化リスト
                    .permitAll()
                    .anyRequest()
                    .authenticated() // 上記以外は全て認証が必要
            )
        .formLogin(Customizer.withDefaults()) // フォームログイン有効化
        .httpBasic(Customizer.withDefaults()) // Basic認証有効化
        .csrf(
            csrf ->
                csrf.ignoringRequestMatchers(
                    "/swagger-ui/**", "/v3/api-docs/**", "/h2-console/**")) // CSRF対策無効化リスト
        .headers(headers -> headers.frameOptions(frame -> frame.disable())); // ブラウザのiframeロックを無効化

    return http.build(); // springに設定済みのセキュリティチェーンを返す
  }
}
