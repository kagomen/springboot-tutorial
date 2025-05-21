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

