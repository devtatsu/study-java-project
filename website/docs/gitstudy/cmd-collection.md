---
sidebar_label: Git操作の基本
title: Git操作の基本と説明
---

多くのプロジェクトではGitを利用する場合、GUIツール（[TortoiseGit](https://tortoisegit.org/) 等）を利用しています。
ですが、Gitの基本を理解することが少なかったりするので、ここでは、説明と併せてコマンドベースで説明していきます。

## ローカルの変更をステージングへ追加

- ローカルの変更を全てステージングへ追加する

```shell
git add .
```

- ローカルの変更の中から一部をステージングへ追加する

```shell
git add ${file_name}
```

## ローカルリポジトリへコミット

```shell
git commit -m 'メッセージ'
```

## リモートリポジトリへプッシュ

```shell
git push
```

:::caution
誤ったブランチへプッシュしない為に`push`前に現在のブランチを確認する。
`git branch --contains`を実行して、その結果が現在のブランチになります。
:::

## Addの取り消し

- 特定のファイルのみ取り消す

```shell
git reset HEAD ${file_name}
```

- 全てのファイルを取り消す（これ使ったことない）

```shell
git reset HEAD
```

## Pushの取り消し

```shell
1. `git reset —hard HEAD^`
1. `git push origin +${branch_name}`
```

## ローカル編集の取り消し

```shell
git checkout .
```

## 変更のあるファイル一覧を確認

```shell
git diff —name-only
```

## Git ブランチ操作

### ブランチの切り替え

- ブランチの一覧を取得

```shell
git branch -a
```

`-a`をつけるとリモート分も含んで一覧出力される

### ブランチの切り替え

```shell
git switch ${branch-name}
```

```shell
git checkout feature/backend-sample
```
リモートのブランチを初めて切り替える場合、`remotes/origin/`部分はいらない

### ブランチの確認

`git branch`

### ブランチの作成

- 作成元になるブランチへ切り替える

```shell
git switch ${branch-name}
```

- ローカルリポジトリ内にブランチを作成

```shell
git checkout -b ${branch-name}
```

- リモートリポジトリへ作成したブランチを登録

```shell
git push -u origin ${branch-name}
```

### ブランチの削除

```shell
git branch -d ${branch-name}
```

### ブランチのマージ

ローカルリポジトリ内で、ブランチ同士のマージ方法を説明します。
ここでの説明は、`master`ブランチを`feature/test`ブランチへマージすることを想定したものになります。

1. ローカルリポジトリを最新化する。
1. ローカルリポジトリのブランチがマージ先（`feature/test`）のブランチになっていることを確認。
1. 取込みたいブランチ（`master`）を指定してマージを実行。

```console title="コマンド実行例"
1. git pull
2. git branch --contains
3. git merge master
```