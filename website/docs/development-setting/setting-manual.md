---
sidebar_label: 開発環境構築
title: 開発環境の構築手順
---

このコンテンツで紹介するサンプルアプリを開発環境で実装または動作させるためには、
以下のものが必要となります。

:::caution
以下で紹介するものが既に開発環境にインストールまたは、設定が完了しているものはスキップしてもらって構いません。
:::

## JDK

このコンテンツで紹介している`REST API`や`バッチサービス`は`Java`で開発しています。
なので、Javaアプリケーションを開発するためには、`JDK`が必要となります。
[公式](https://www.oracle.com/java/technologies/downloads/)からダウンロードして、インストールしてください。
バージョンは、JDK 8以上であれば、問題ありません。

## Git

このコンテンツは、[`GitHub`](https://github.co.jp/)で公開しています。
公開しているサンプルアプリは、`Git`を利用して、自身の環境に`Clone`することができます。
ですので、以下開発環境にあうものをダウンロードして、インストールしてください。

 - [Windows版](https://gitforwindows.org/)
 - [Mac版](https://git-scm.com/download/mac)

 また、`GitHub`のアカウントを持っていない場合は、[ここから](https://github.com/signup?source=login)アカウントを作成してください。

## Visual Studio Code（以降、`VSCode`と呼称）（任意）

:::caution
`VSCode`はインストール必須ではありませんので、自身が使いやすいものを利用してください。
特にこだわりがなければ、`VSCode`を利用することをお勧めします。
:::

このコンテンツでは、[`VSCode`）](https://code.visualstudio.com/)をベースに説明を進めています。
`VSCode`を利用する際に必要なプラグインは、それぞれのサンプルアプリの`extensions.json`に定義していますので、
`VSCode`を起動した際に不足があれば、必要なプラグインを案内に沿ってインストールしてください。
