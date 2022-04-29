## 参考

`https://spring.pleiades.io/guides/gs/rest-service/`

## 必要なもの

このサンプルを利用するにあたり必要なもの

- [VSCode(Visual Studio Code)](https://code.visualstudio.com/)（※1）
- git
開発環境のOSにあわせて、以下どちらかをインストール
 - [Windows版](https://gitforwindows.org/)
 - [Mac版](https://git-scm.com/download/mac)

※1 必須ではないが、推奨

## Gradle

- クリーン
`gradle clean`

- ビルド
`gradle build`

- ビルド(テストスキップ)

`gradle build -x test`

- クリーン & ビルド
`gradle clean build`

- クリーン & ビルド(テストスキップ)
`gradle clean build -x test`

- サブプロジェクト単位のビルド

`gradle :{$sub-project-name}:build`

## 実行

- サービス起動

`demo`直下で、以下のコマンドを実行。

`./gradlew :rest-api:bootRun`

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

- 全体のプロジェクト構成
マルチプロジェクト

- サブプロジェクト含めたプロジェクト（レイア）構成
https://qiita.com/YutaKase6/items/7d88fa23f81366905270

### DB

- H2
このrepositoryをcloneして、簡易的に利用が出来ることを目的に、デフォルト設定は`H2`を利用しています。

## トラブルシューティング

### プロジェクト構成後、`import`が正しく読み込まれない

プロジェクト構成変更直後、`vsCode`の場合、正しくパスが読み込まれないことがある。
その為、`import`文が正しく読み込まれない場合は、以下を実行すれば、解消される。

- `demo`直下で、`gradle eclipse`コマンドを実行する
- `vsCode`を再起動する
