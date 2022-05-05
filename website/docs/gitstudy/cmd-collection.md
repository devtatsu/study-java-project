## ローカルの変更をステージングへ追加

- ローカルの変更を全てステージングへ追加する

`git add .`

- ローカルの変更の中から一部をステージングへ追加する

`git add {file_name}`

## ローカルリポジトリへコミット

`git commit -m ‘メッセージ’`

## リモートリポジトリへプッシュ

`git push`

＜注意＞
誤ったブランチへプッシュしない為に`push`前に現在のブランチを確認する。

## Addの取り消し

- 特定のファイルのみ取り消す

`git reset HEAD {file_name}`

- 全てのファイルを取り消す（これ使ったことない）

`git reset HEAD`

## Pushの取り消し

1. `git reset —hard HEAD^`
1. `git push origin +{branch_name}`

## ローカル編集の取り消し

`git checkout .`

## 変更のあるファイル一覧を確認

`git diff —name-only`

## Git ブランチ操作

### ブランチの切り替え

- ブランチの一覧を取得

`git branch -a`
`-a`をつけるとリモート分も含んで一覧出力される

### ブランチの切り替え

`git switch {branch-name}`

```
`git checkout feature/backend-sample`
リモートのブランチを初めて切り替える場合、`remotes/origin/`部分はいらない
```

### ブランチの確認

`git branch`

### ブランチの作成

- 作成元になるブランチへ切り替える
`git switch {branch-name}`

- ローカルリポジトリ内にブランチを作成
`git checkout -b {branch-name}`

- リモートリポジトリへ作成したブランチを登録
`git push -u origin {branch-name}`

### ブランチのマージ

コミット
git commit -m”feature/upgrade-expo-42” -m”修正 コミットログの取込み(Flipperの無効)”

・マージ
master → feature/upgrade-expo-42へマージしたい場合

１．マージ元（master）を最新版をpullする
２．現在のブランチがマージ先のブランチ（feature/upgrade-expo-42）になっていることを確認 
	git branch
３．取込みたいブランチを指定してマージを実行
	git merge master
