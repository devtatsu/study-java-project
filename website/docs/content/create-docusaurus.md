---
sidebar_label: コンテンツの作成と運用
title: コンテンツの作成と運用
---

## コンテンツプロジェクトの作成

:::caution
[Node.js](https://nodejs.org/ja/download/)（LTS 12.13.0以上）が必要です。
:::

以下のコマンドを実行してプロジェクトを作成します。

```console title="コマンド テンプレート"
npx @docusaurus/init@latest init [contents-name] [template]
```

上記のテンプレートを使用した例は以下のとおりです。

```console title="実行コマンド例"
npx @docusaurus/init@latest init website classic
```

:::note info
templateは、Docusaurusの基本機能が網羅されていてカスタマイズしやすく、Docusaurus 1の機能も含まれているclassicの利用が推奨されています。
特に理由がなければclassicテンプレートで良いです。
:::

コマンド実行後、パッケージのインストール要否確認が以下のようにコンソールに出力されますが、'y（Yes）'で問題ありません。

```console title="メッセージ表示例"
Need to install the following packages:
  @docusaurus/init@latest
Ok to proceed? (y)
```

上記にて、プロジェクトが作成されます。
それぞれのディレクトリの役割は以下のとおりです。

| NO | ディレクトリ | 役割 | 備考 |
| --- | :--- | :--- | :--- |
| 1 | /blog/ | ブログ記事用のディレクトリで、サンプルのマークダウンファイルが格納されています。 | ブログが不要な場合はこのディレクトリを削除します。 |
| 2 | /docs/ | ドキュメント用のディレクトリで、サンプルのマークダウンファイルが格納されています。sidebars.jsを編集することでドキュメントの順番等を変更できます。 | ― |
| 3 | /src/ | ドキュメントサイトやReactのカスタマイズ用コンポーネント等以外のファイルを格納するディレクトリです。 | 特に非ドキュメント用ファイルをここに置く必要があるという訳ではありませんが、それらのファイルをこのディレクトリに置いておく事でリンティングなどの処理を行う際に特定しやすいとのことです。 |
| 4 | /src/pages | このディレクトリに保存されるファイルはウェブサイトのページとして変換されます。 | Docusaurusインストール時のトップページもこのディレクトリに格納されています。WordPressで言う所の固定ページ用のディレクトリと言えます。 |
| 5 | /static/ | Docusaurusによって動的に変換されないファイルを格納するディレクトリです。 | 画像などは、/static/img配下に格納します。/static/配下のコンテンツは、最終的にビルドされるディレクトリのルートディレクトリにそのままコピーされます。 |
| 6 | /docusaurus.config.js | サイトの設定を記述するファイルです。 | Docusaurus v1のsiteConfig.jsと同じ役割を担います。 |
| 7 | /package.json | npmパッケージが記述されているファイルです。 | 追加でnpmパッケージをインストールして利用する事ができます。 |
| 8 | /sidebar.js | ドキュメントサイトのサイドバーに表示させる各ページの順番等を定義するファイルです。 | ― |

このコンテンツは、作成したプロジェクトの中から、`blog`と`src/pages`が不要なため、削除しています。
削除したコンテンツのディレクトリ構成は以下のとおりです。

```bat title="ディレクトリ構成（第一階層まで）"
[contents-name]
├── docs
├── src
└── static
```

## コンテンツの起動

コマンドプロンプトまたは、ターミナルにてコマンドを実行してデフォルト作成したコンテンツを起動します。

```console title="作成したプロジェクトまでカレントを移動"
cd [contents-name]
```

```console title="サイトの起動"
npm start
```

上記のサイト起動コマンド実行後、コンソールにエラーが表示されていなければ、起動は成功です。
`http://localhost:3000/`へアクセスして、サイトが表示されていることを確認。

## docsディレクトリをサイトのホームにする

デフォルトの状態だと、`/src/pages/index.js`のページがサイトのホームページ（トップページ）になります。
今回は、`docs`配下のページのみでドキュメントサイトを構築していくため、サイトのホームも`docs`ディレクトリ配下のページにします。
そのため、まずは`docusaurus.config.js`を開き、`presets`の配下の`docs`の配列に、以下を追加します。

```diff title="docusaurus.config.js"

/* ～省略～ */

  presets: [
    [
      '@docusaurus/preset-classic',
      /** @type {import('@docusaurus/preset-classic').Options} */
      ({
        docs: {
+          routeBasePath: '/',
          sidebarPath: require.resolve('./sidebars.js'),
        },
        blog: {
          showReadingTime: true,
          // Please change this to your repo.
          editUrl:
            'https://github.com/facebook/docusaurus/edit/main/website/blog/',
        },
        theme: {
          customCss: require.resolve('./src/css/custom.css'),
        },
      }),
    ],
  ],


/* ～省略～ */

```

## pagesの削除

不要となった`pages`を削除します。

`/src/pages/`

デフォルトのトップページのみを削除する場合は以下のファイルを削除してください。

`/src/pages/index.js`

サーバー起動中にこのディレクトリやファイルを削除するとブラウザにエラーメッセージが表示されるか、`Page Not Foundが`表示されます。
これは、デフォルトのトップページ`/src/pages/index.js`の代わりに利用したいトップページを指定できていないために発生しています。
これを解消するために、`docs`ディレクトリにトップページ用のマークダウンファイルを作成し、URLを指定する`slug`を追加します。

例として、以下の`my-home.md`を作成します。

`[contents-name]/docs/my-home.md`

`my-home.md`に`slug`を記述します。

```diff title="my-home.md"
+---
+slug: /
+---
```

これでトップページ`http://localhost:3000/`にアクセスすると、先ほど指定した`/my-website/docs/my-home.md`が表示されます。

## ヘッダー・フッターの編集

### ヘッダーの編集

ヘッダーやフッター、ロゴ画像は、`docusaurus.config.js`の中の`themeConfig`を編集することで変更できます。
まずヘッダーナビゲーションは以下の`navbar`オブジェクトを編集します。
また、既に削除した`blog`のリンクは不要なので以下の箇所は削除します。

```diff title="docusaurus.config.js"

/* ～省略～ */

  themeConfig:
    /** @type {import('@docusaurus/preset-classic').ThemeConfig} */
    ({
      navbar: {
-        title: 'My Site',
+        title: 'ZATTA PRODUCTION DOCUMENTATION',
        logo: {
          alt: 'My Site Logo',
          src: 'img/logo.svg',
        },
        items: [
          {
            type: 'doc',
            docId: 'home',
            position: 'left',
-            label: 'Tutorial'
+            label: 'Site Home',
          },
-          {to: '/blog', label: 'Blog', position: 'left'},
          {
-            href: 'https://github.com/facebook/docusaurus',
+            href: 'https://zatta.link/about/',
-            label: 'ABOUT ZATTA PRODUCTION',
+            label: 'GitHub',
            position: 'right',
          },
        ],
      },

/* ～省略～ */

```

#### サイトの基本情報を編集する

サイトの基本的な情報は、`docusaurus.config.js`の冒頭の以下の箇所で設定します。
`url`には、最終的にビルドしたファイルをアップロードする`URL`(今回はGithub Pagesにアップロードするので、そのURL)を入力してください。
ここを正しく入力しないとビルドした際にサイト内のリンクが正しく出力されません。
faviconもここで設定可能です。
`organizationName`にはGitHubの組織名かユーザー名を、`projectName`にはリポジトリ名を入力するようです。

```diff title="docusaurus.config.js"

+const project = '[リポジトリ]';
+const gituser = '[Gitユーザ]';


/* ～省略～ */

-url: 'https://your-docusaurus-test-site.com',
+url: `https://${gituser}.github.io`,
-baseUrl: '/',
+baseUrl: `/${project}/`,
onBrokenLinks: 'throw',
onBrokenMarkdownLinks: 'warn',
favicon: 'img/favicon.ico',
-organizationName: 'facebook',
+organizationName: gituser,
-projectName: 'docusaurus',
+projectName: project,


/* ～省略～ */

```

新たなドキュメント用ページ `docs/home.md`を追加しています。
`docs/home.md`には、以下を記述しています。

```diff title="docusaurus.config.js"
+sidebar_position: 1
+id: home
```

### フッターとコピーライトの編集

ヘッダー同様に、`footer`、`copyright`を書き換える事で変更可能です。
なお、サイトのホームページを`docs`配下のファイルに変更してあるため、フッターのリンクが`/docs/your-page`となっている場合は、リンク切れが発生しますので、`docs`を削除する必要があります。

#### blogを削除する

`/blog/`ディレクトリは使用しないため、削除しましょう。
また、`docusaurus.config.js`の`blog`の設定箇所も削除します。

```diff title="docusaurus.config.js"

/* ～省略～ */

  presets: [
    [
      '@docusaurus/preset-classic',
      /** @type {import('@docusaurus/preset-classic').Options} */
      ({
        docs: {
          sidebarPath: require.resolve('./sidebars.js'),
          // Please change this to your repo.
          editUrl: 'https://github.com/facebook/docusaurus/edit/main/website/',
        },
-        blog: {
-          showReadingTime: true,
-          // Please change this to your repo.
-          editUrl:
-            'https://github.com/facebook/docusaurus/edit/main/website/blog/',
-        },
        theme: {
          customCss: require.resolve('./src/css/custom.css'),
        },
      }),
    ],
  ],

/* ～省略～ */

```

## サイドバーメニューの編集

サイドバーメニューの編集方法を説明します。

```diff title="sidebars.js"

module.exports = {
-  // By default, Docusaurus generates a sidebar from the docs folder structure
-  tutorialSidebar: [{type: 'autogenerated', dirName: '.'}],

-  // But you can create a sidebar manually
-  /*
-  tutorialSidebar: [
-    {
-      type: 'category',
-      label: 'Tutorial',
-      items: ['hello'],
-    },
-  ],
-   */
+  mySidebar: {
+    はじめに: [
+      'my-home',
+      'home',
+    ],
+    コンテンツ: [
+      'create-docusaurus'
+    ],
+  },
};

```

## 不要なディレクトリやファイルの削除

`docs`配下の以下のディレクトリやファイルは不要なため、削除

- `tutorial-basics`
- `tutorial-extras`
- `intro.md`

## ビルド

以下のコマンドでビルドします。

```console title="ビルドコマンド"
npm run build
```

これで、`build`ディレクトリが作成され、そこに本番環境用のファイルが生成されます。
このファイル一式をサーバーにアップすればサイトが表示されます。

### ローカル環境での確認

以下のコマンドを実行すると、`build`ディレクトリのファイルを`http://localhost:3000/study-java-project/`で実行する事ができます。

```console title="ビルドコマンド"
npm run serve
```

## デプロイ

以下のコマンドを実行して、デプロイする。

```shell title="デプロイコマンド(Bash)"
GIT_USER=${git user}(※1) GIT_PASS=${git user}(※2) yarn deploy
```

```bat title="デプロイコマンド(Windows)"
cmd /C "set "GIT_USER=${git user}(※1)" && set "GIT_PASS=${git user}(※2)" && yarn deploy"
```

```bat title="デプロイコマンド(PowerShell)"
cmd /C 'set "GIT_USER=${git user}(※1)" && set "GIT_PASS=${git user}(※2)" && yarn deploy'
```

デプロイすると、`gh-pages`ブランチが作成されて、ビルドしたファイルだけがgh-pagesブランチに展開される。
ただし、ページ間のリンク先が存在していないと、エラーになってデプロイできないので注意する。

(※1) gitのログインユーザ

(※2) git アクセストークン。アクセストークンの作成は、[個人アクセストークンを使用する](https://docs.github.com/ja/authentication/keeping-your-account-and-data-secure/creating-a-personal-access-token)を参照。


## GitHub Pagesの設定

[GitHub](https://github.com/)へログインして、以下の流れで設定します。

(※3) 無償のリポジトリで設定する場合、publicでないと設定できない

1. 設定するリポジトリへ移動(※3)
1. [Settings] > [Pages]へ移動して、[Sourse]内の各項目を以下の通り設定する
   - Branch: gh-pages
   - /(root)
   - [Save]を押下

リポジトリホーム内の`About`の`⚙`を押下して、`Website`へ、公開する部分のURLを設定する
例）https://devtatsu.github.io/study-java-project/

## 運用

修正等の更新が発生した場合、以下の手順で運用

1. ローカルで修正および、[動作確認](#ビルド)
2. [デプロイ](#デプロイ)
