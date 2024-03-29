---
sidebar_label: 入力と出力項目
title: 入力／出力項目の設計
---

ここでは、APIへリクエストを送信する際の入力項目とAPIからのレスポンス結果の出力項目を指します。
入力、出力いずれもリクエスト送信元と確認や調整をし、設計していくものになります。

:::info
入力や出力項目は設計以降もリクエスト元からの調整や仕様変更等で変更が発生する機会が度々発生します。
なので、設計書を作成する際は後で修正しやすいように作成しておくことが望ましいです。
例えば、項目定義は文章形式で記載するのではなく、箇条書きや表形式で記載します。
項目追加があった場合は、コピー&ペーストで追記するようにすれば修正しやすいです。
:::

## 入力項目の設計

### 形式

形式とは、`JSON`や`XML`などを指します。
これは、リクエスト元（クライアント）と形式を合わせる必要があります。

### 項目

項目は、`項目名（論理名と物理名）`とその項目の型を決めます。
そして、それぞれの項目の単項目チェックと相関チェックの要否を決めます。
チェック結果、入力要件を満たしていない場合の挙動についても纏める必要があります。

上記を決めたら、設計書へは以下のように取りまとめます。

- データ形式：`JSON`
- データ項目

| NO | 項目名(論理) | 項目名(物理) | 型 | サイズ | 説明 | 必須チェック | 相関チェック | 属性チェック | 外字チェック |
| --- | :--- | :--- | :--- | :--- | :--- | :--- | :--- | :--- | :--- |
| 1 | 社員ID | employeeid | 文字列 | 6 |  | あり | なし | なし | あり |
| 2 | 氏名(姓) | lastname | 文字列 | 5 |  | なし | 有 | なし | あり |
| 3 | 氏名(名) | firstname | 文字列 | 5 |  | なし | 有 | なし | あり |
| 4 | 部門 | department | 文字列 | 255 |  | なし | なし | なし | あり |
| 5 | 入社日 | hireDate | 文字列 | 10 | 日付形式：yyyy/MM/dd | なし | なし | 日付 | あり |

<!-- 参考情報 https://it-biz.online/it-skills/check-the-input/ -->
<!-- 参考情報 https://docs.microsoft.com/ja-jp/azure/architecture/best-practices/api-design -->

### バリデーションチェック

一般的に入力値に対して、`バリデーションチェック`を実施します。
理由は、後続処理に影響のある値を受け付けないようにするためです。
バリデーションチェックには以下のようなものがあります。

- 必須チェック
必須項目に対して、入力値が存在するかをチェックします。

- 文字列長チェック
指定した文字数の範囲内に入力値の文字数がなっていることをチェックします。

- 属性チェック
入力された項目が、指定されたデータ型と一致していることをチェックします。
例）日付型を許容しているのに、値が日付以外のものになっていないことをチェック 等

- 外字チェック
外字チェックは、システムに存在しない文字が含まれていないことをチェックします。
例）備考欄にS-JIS以外の文字（例えば、`㉚` 等）が入力されていないことをチェック 等

- 相関チェック
相関チェックは、複数の項目に入力された値の妥当性のチェックです。
例）氏名の姓と名の項目があり、どちらかの項目の値が存在する場合、対の項目も値が存在することをチェック 等

- 存在チェック
DB操作（CRUD）をする場合にチェックします。
入力値を使用して、条件に該当するデータを検索した結果、該当するデータが存在することをチェックします。

:::caution
DB操作がない場合は、このチェックをすることは少ないです。
:::

- 権限チェック
権限チェックは、入力された値によるデータへのアクセス権限をチェックします。
例）指定された会社コードの参照権限があること

上記のチェックについて、エラーに該当する条件やレスポンス結果を設計書にまとめていきます。
それぞれのチェックは、以下のようにタイプ分することができます。

| NO | チェック | Type |
| --- | :--- | :--- |
| 1 | 必須チェック | [A](#typea) |
| 2 | 文字列長チェック | [A](#typea) |
| 3 | 属性チェック | [A](#typea) |
| 4 | 外字チェック | [A](#typea) |
| 5 | 相関チェック | [B](#typeb) |
| 6 | 存在チェック | [C](#typec) |
| 7 | 権限チェック | [C](#typec) |

#### Type.A

このタイプは、単体の入力項目を対象に入力値として許容可能かを判定します。
条件や、レスポンスは以下のとおりです。

- 対象項目：項目名（例：社員ID（employeeId））
- 条件：入力チェックの条件（例：値が`null`の場合（入力I/Fに項目が存在しないのも含む））
- HTTPステータス：レスポンスとして返却するHTTPステータス（例：400(Bad Request)）
- コード：レスポンスとして返却するエラーコード（例："W-0001"）
- メッセージ：レスポンスとして返却するエラーメッセージ（例："{項目名}は必須項目です"）
- レスポンスbody（JSON形式）：レスポンスbodyのインターフェース[^1]
```json title="出力例"

{
  "code":"W-0001",
  "msg":"氏名(姓)は必須項目です。"
}

```

#### Type.B

このタイプは、複数の入力項目を対象に入力値として許容可能かを判定します。
条件や、レスポンスは以下のとおりです。

- 対象項目：項目名（例：氏名(姓)（lastname）、氏名(名)（firstname））
- 条件：入力チェックの条件（例：どちらかの項目または、値が存在する場合、対の項目または、値が存在しない場合）
- HTTPステータス：レスポンスとして返却するHTTPステータス（例：400(Bad Request)）
- コード：レスポンスとして返却するエラーコード（例："W-0002"）
- メッセージ：レスポンスとして返却するエラーメッセージ（例："{項目名}が存在しません。"）
- レスポンスbody（JSON形式）：レスポンスbodyのインターフェース[^1]
```json title="出力例"
{
  "code":"W-0002",
  "msg":"氏名(姓)が存在しません。"
}
```

#### Type.C

このタイプは、入力項目を使用して、DB検索を実行し、データが存在するかを判定します。
条件や、レスポンスは以下のとおりです。

- 対象項目：項目名（例：社員ID（employeeId））
- 条件：入力チェックの条件（例：社員IDで、Employeeを検索して、該当するデータが存在しない場合）
- HTTPステータス：レスポンスとして返却するHTTPステータス（例：400(Bad Request)）
- コード：レスポンスとして返却するエラーコード（例："E-0001"）
- メッセージ：レスポンスとして返却するエラーメッセージ（例："社員ID:{`社員ID`}に該当するデータが存在しません"）
- レスポンスbody（JSON形式）：レスポンスbodyのインターフェース[^1]
```json title="出力例"

{
  "code":"E-0001",
  "msg":"社員ID:`2022040001`に該当するデータが存在しません"
}

```

## 出力項目の設計

| NO | 項目名(論理) | 項目名(物理) | 型 | サイズ | 説明 |
| --- | :--- | :--- | :--- | :--- | :--- |
| 1 | 社員リスト | employeelist | 配列 | ― | ― |
| 2 | 社員ID | employeeid | 文字列 | 6 | ― |
| 3 | 氏名(姓) | lastname | 文字列 | 5 | ― |
| 4 | 氏名(名) | firstname | 文字列 | 5 | ― |
| 5 | 部門 | department | 文字列 | 255 | ― |
| 6 | 入社日 | hireDate | 文字列 | 10 | 日付形式：yyyy/MM/dd |

```json title="HTTPステータス：200（OK） 出力例"

{
	"employeelist": [
		{
			"employeeId": "2022040001",
			"lastname": "サンプル",
			"firstname": "一郎",
			"department": "システム部",
			"hireDate": "2022/07/01"
		},
		{
			"employeeId": "2022040001",
			"lastname": "サンプル",
			"firstname": "次郎",
			"department": "システム部",
			"hireDate": "2022/07/01"
		}
	]
}

```

[^1]:設計書に記載するJSONは必ず、形式として間違いがないことを確認しましょう。webで[JSON Pretty Linter](https://lab.syncer.jp/Tool/JSON-Viewer/)など便利なツールが公開されており、
そういったツールを利用すると簡単に確認できるのでおすすめです。
