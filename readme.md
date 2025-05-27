## Gradle 関係

- build.gradle
  - Gradle の設定ファイル
- gradle/
  - Gradle Wrapper の設定ファイル群
- gradlew
  - Gradle Wrapper の実行スクリプト（UNIX 用）
- gradlew.bat
  - Gradle Wrapper の実行スクリプト（Windows 用）
- .gradle/
  - Gradle のビルドキャッシュ

## コマンド

- `build.gradle`の`mainClass`に指定したファイルの実行

```bash
./gradlew run
```

- 開発用サーバ立ち上げ

```bash
./gradlew bootRun
```

- ビルド&動作確認

```bash
./gradlew bootJar
java -jar build/libs/springboot-tutorial-0.0.1.jar
```

- フォーマッター

```bash
./gradlew spotlessApply
```

- 本番環境

```bash
./gradlew bootRun --args='--spring.profiles.active=prod'
```

## OpenAPI セットアップ

- 依存の追加

```bash
# build.gradle

dependencies {
    implementation 'org.springdoc:springdoc-openapi-starter-webmvc-ui:2.5.0'
}
```

- `./gradlew bootRun`でサーバー起動
- http://localhost:8080/swagger-ui.html にアクセス
