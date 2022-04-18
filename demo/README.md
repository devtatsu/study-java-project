## 参考

`https://spring.pleiades.io/guides/gs/rest-service/`

## Gradle

`gradle clean`

- ビルド
`gradle build`

- ビルド(テストスキップ)

`gradle build -x test`

## 実行

- サービス起動

`demo`直下で、以下のコマンドを実行。

`./gradlew bootRun`

- 確認

サービス起動後、以下にアクセスして、確認。

`http://localhost:8080/greeting`

## ドキュメントに纏める内容

### スペック

- JDK:1.8
- Spring Boot:2.6

### 初回プロジェクト作成時のポイント

`settings.gradle`に定義する`rootProject.name`と実際のアプリのパス名が相違していると正常に動作しない。

### プロジェクト構成

https://qiita.com/YutaKase6/items/7d88fa23f81366905270

### DB


