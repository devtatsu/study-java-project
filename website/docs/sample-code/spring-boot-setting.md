---
sidebar_label: 開発環境構築
title: 開発環境の構築手順
---

サンプルとして紹介するプロジェクトの設定内容と方法を紹介します。

## ビルドツール

ビルドツールは、[Gradle](https://docs.gradle.org/current/userguide/what_is_gradle.html)を使用しています。

## 各種ツール

このリポジトリには、以下のツールを導入しています。

- [checkstyle](#checkstyle)
- [spotbugs](#spotbugs)
- [jacoco](#jacoco)

それぞれの設定方法は以下の通りです。

### checkstyle

`checkstyle`とは、コーディング規約に則ったJavaコードを書くのを補助する開発ツールです。
プロジェクトで定められたコーディング規約を確実に守りつつ、プロジェクトを進めるための非常に有用なツールです。

コーディング規約を纏めた`checkstyle.xml`（ファイル名は任意）と`build.gradle`の設定は以下の通りです。

- checkstyle.xml

任意の場所にXMLファイルを作成します。
ここでは、ルート直下へ以下のとおりに作成します。

```
demo
┗config
  ┗checkstyle
    ┗checkstyle.xml
```

`checkstyle.xml`に定義するコーディング規約は、[公式](https://github.com/checkstyle/checkstyle/tree/master/src/main/resources)で公開されているものを
利用して、カスタマイズしていくのが便利です。

- build.gradle

```gradle

plugins {
	id 'checkstyle'
}

// --- 省略 ---

subprojects {

	apply plugin: "checkstyle"

    // --- 省略 ---

	checkstyle {
		toolVersion '8.37'
		configFile = rootProject.file('config/checkstyle/checkstyle.xml')
		ignoreFailures true
	}

    // --- 省略 ---

	tasks.withType(AbstractCompile).each { it.options.encoding = 'UTF-8' }

    // --- 省略 ---

}

// --- 省略 ---

```

- 特定パッケージやソースの除外設定

特定のソース（自動生成されたソース等）やパッケージ配下のソースに対して、checkstyleの適応を除外する設定は以下です。

- 除外定義ファイル

特定のパッケージやファイルを除外する定義を記載したXMLファイルを以下の通り、作成します。

```
demo
┗config
  ┗checkstyle
    ┗suppressions.xml （ファイル名は任意）
```

作成した`suppressions.xml`の内容は以下の通りです。

```xml

<?xml version="1.0"?>
<!DOCTYPE suppressions PUBLIC
  "-//Checkstyle//DTD SuppressionFilter Configuration 1.2//EN"
  "https://checkstyle.org/dtds/suppressions_1_2.dtd">

<suppressions>
  <suppress checks=".*" files=".*DemoApplication.java$" />
  <suppress checks=".*" files="com[\\/]example[\\/]demo[\\/]resource[\\/].*.java$"/>
</suppressions>

```

詳細については、[公式](https://checkstyle.sourceforge.io/config_filters.html#SuppressionFilter)を参照。

- checkstyle.xml

上記で作成した`suppressions.xml`を読み込むように、`checkstyle.xml`へ、以下のとおり追記または、修正します。
`${config_loc}`はCheckstyleのビルトインのプロパティでプロジェクト直下の`config`フォルダの意味になります。

```xml

<module name="SuppressionFilter">
 <property name="file" value="${config_loc}/suppressions.xml"/>
 <property name="optional" value="false"/>
</module>

```

### spotbugs

`spotbugs`とは、Javaプログラムの中のバグを見つけるプログラムです。
他にも`findbugs`といったツールもありますが、これは2015年から更新されていないので、
今回は、`spotbugs`を利用しています。

解析ルールを纏めた`customfilter.xml`（ファイル名は任意）と`build.gradle`の設定は以下の通りです。

- customfilter.xml

任意の場所にXMLファイルを作成します。
ここでは、ルート直下へ以下のとおりに作成します。

```
demo
┗config
  ┗spotbugs
    ┗customfilter.xml
```

- build.gradle

```gradle

plugins {
	id "com.github.spotbugs" version "5.0.6"
}

// --- 省略 ---

subprojects {

	apply plugin: "com.github.spotbugs"

	spotbugs {
		toolVersion = '4.6.0'
		ignoreFailures = true
		spotbugsTest.enabled = false
		includeFilter = rootProject.file('config/spotbugs/customfilter.xml')
	}

    // --- 省略 ---

	spotbugsMain {
		reports {
			html {
				enabled = true
			}
		}
	}

    // --- 省略 ---

	dependencies {
		spotbugsSlf4j group: 'org.slf4j', name: 'slf4j-api', version: '1.8.0-beta4'
		spotbugsSlf4j group: 'org.slf4j', name: 'slf4j-simple', version: '1.8.0-beta4'
	}

    // --- 省略 ---

}

// --- 省略 ---

```

```console

> Task :rest-api:spotbugsMain
SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
SLF4J: Defaulting to no-operation (NOP) logger implementation
SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.

```

上記に対応するため、`dependencies`に以下を入れています。

```gradle

dependencies {
    spotbugsSlf4j group: 'org.slf4j', name: 'slf4j-api', version: '1.8.0-beta4'
    spotbugsSlf4j group: 'org.slf4j', name: 'slf4j-simple', version: '1.8.0-beta4'
}

```

### jacoco

`jacoco`とは、Javaの単体テストでコードカバレッジのレポートが出力できるライブラリです。
カバレッジはステートメントカバレッジ(C0)とブランチカバレッジ(C1)が取得できます。

`build.gradle`の設定は以下の通りです。

- build.gradle

```gradle

plugins {
	id 'jacoco'
}

// --- 省略 ---

bootJar {
	enabled = false
}

jar {
	enabled = false
}

// カバレッジレポート除外リスト
def jacocoExclusions = [
	'**/common/constants/*',
	'**/controller/request/*',
	'**/controller/response/*',
	'**/resource/*',
	'**/domain/models/*',
	'**/demo/DemoApplication.class'
];

subprojects {

	apply plugin: "jacoco"

    // --- 省略 ---

	tasks.withType(AbstractCompile).each { it.options.encoding = 'UTF-8' }

	test.finalizedBy jacocoTestReport

	jacocoTestReport {

		reports {
			html.enabled = true
		}

		afterEvaluate {
			classDirectories.setFrom(classDirectories.files.collect {
				fileTree(dir: it, excludes: jacocoExclusions )
			})
		}

	}

    // --- 省略 ---

}

project(":rest-api") {

    bootJar {
        enabled = true
    }

	jar {
		enabled = true
	}

    // --- 省略 ---

}

project(":spring-jpa") {

    bootJar {
        enabled = false
    }

	jar {
		enabled = true
	}
	
}

project(":common") {

    bootJar {
        enabled = false
    }

	jar {
		enabled = true
	}

}


```

## JUnit

JUnit5とJUnit4を含めた以前のバージョンを共存させる設定を紹介します。

- build.gradle

```gradle

subprojects {

    // --- 省略 ---
 
	dependencyManagement {
		imports {
			mavenBom "org.junit:junit-bom:5.4.2"
		}
	}

	// --- 省略 ---

	dependencies {
		testImplementation('org.springframework.boot:spring-boot-starter-test') {
			exclude group: 'junit', module: 'junit'
		}
		testImplementation 'org.junit.jupiter:junit-jupiter'//JUnit5のAPI
		testRuntimeOnly 'org.junit.platform:junit-platform-launcher'//IDEなどのサポート用
		testRuntimeOnly 'org.junit.vintage:junit-vintage-engine'//JUnit3,4対応
		testCompileOnly 'junit:junit'//Junit5のBOMからJunit4を入れなおせば、4以前のテストも競合しないようです
	}

    // test {
    //     useJUnitPlatform()
    // }

	// --- 省略 ---

}

// --- 省略 ---

```

JUnit5を利用する場合は、以下のコメントを外すことで利用可能です。

```gradle

// test {
//     useJUnitPlatform()
// }

```

## マルチプロジェクト

複数のサブプロジェクトを含めたマルチプロジェクトを実現するための設定を紹介します。

- build.gradle

```gradle

// ここはルートプロジェクトに対する設定

subprojects {

	// ここはサブプロジェクト全体で共通するものを設定

}

// 以降は個々のサブプロジェクト毎で必要なものを設定

project(":rest-api") {

    bootJar {
        enabled = true
    }

	jar {
		enabled = true
	}

    dependencies {

		// 必要に応じて、他のサブプロジェクトへの依存関係を設定
		implementation project(':spring-jpa')
		implementation project(":common")
    }

}

project(":spring-jpa") {

    bootJar {
        enabled = false
    }

	jar {
		enabled = true
	}
	
}

project(":common") {

    bootJar {
        enabled = false
    }

	jar {
		enabled = true
	}

}


```

## sourceSetsの設定

テストコードで、`@Sql`を利用して、テスト時に必要となるテストデータを設定するsqlファイルの読み込み先を
`build.gradle`へ以下のように設定します。

```gradle

sourceSets {
	main {
		java {
			srcDirs = [ 'src/main/java' ]
		}
	}
	test {
		java {
			srcDirs = [ 'src/test/java' ]
		}
		resources {
			srcDirs = [ 'src/test/resources' ]
		}
	}
}

```

## vsCode設定（任意）

vsCodeを使用して、設定内容を共通化する際の各種設定方法を紹介します。

- [拡張機能](#拡張機能)
- [フォーマッタ](#フォーマッタ)
- [タブ設定](#タブ設定)
- [ターミナルの文字化け対策](#ターミナルの文字化け対策)

### 拡張機能

ルート直下に`.vscode`フォルダを作成して、その直下に`extensions.json`ファイルを作成します。
その作成したjsonファイル内に自身でインストールした拡張機能を以下のように定義していきます。

```json

{
    "recommendations": [
        "vscjava.vscode-java-pack",
        "redhat.java",
        "GabrielBB.vscode-lombok",
        "Pivotal.vscode-boot-dev-pack",
    ]
}

```

上記を設定しておくことで、このリポジトリをcloneした人がそれらの拡張機能をインストールしていない場合、
vscodeを起動した際にインストールを促すポップアップが表示されるようになります。
定義する内容は、インストールする拡張機能内の`⚙`を選択して、`拡張機能IDのコピー`を選択することで、
定義する内容を取得できます。

### フォーマッタ

ルート直下に`.vscode`フォルダを作成して、その直下に`settings.json`ファイルを作成します。
その作成したjsonファイル内にフォーマッタを以下のように定義します。

```json

"java.format.settings.url": "https://raw.githubusercontent.com/google/styleguide/gh-pages/eclipse-java-google-style.xml",
"java.format.settings.profile": "GoogleStyle",

```

上記で使用しているのは`Google`が提供しているものです。
独自で作成し、利用することもの可能です。

次にフォーマッタをソースのペーストや保存時に自動で実行してくれる設定を定義します。
これも、`settings.json`内へ定義します。

```json

"[java]": {
	"editor.formatOnPaste": true,
	"editor.formatOnSave": true,
	"editor.formatOnType": true,
},

```

上記の設定は以下を表しています。

- ペースト時にフォーマットする
- 保存時にフォーマットする

### タブ設定

ルート直下に`.vscode`フォルダを作成して、その直下に`settings.json`ファイルを作成します。
その作成したjsonファイル内にタブやを以下のように定義します。

```json

"[java]": {
	"editor.tabSize": 4,
	"editor.insertSpaces": true,
	"editor.detectIndentation": false,
},

```

上記の設定は以下を表しています。

- タブサイズは、スペース4つ分
- タブは、タブではなくスペースにする

### ターミナルの文字化け対策

ターミナルの文字化け対策として、設定を定義します。
ルート直下に`.vscode`フォルダを作成して、その直下に`settings.json`ファイルを作成します。
その作成したjsonファイル内へ以下のように定義します。

```json

"terminal.integrated.profiles.windows": {
	"PowerShell": {
		// "PowerShell"と"Git Bush"に対してはパスを指定する必要がない
		"source": "PowerShell",
		// PowerShellの実行ファイル名の後ろに引数を付けて、
		// 実行させることが可能
		"args": [
			// コマンド実行後もPowerShellを閉じない
			"-NoExit",
			// 文字コードをUTF-8に変更するコマンドを実行
			"-Command",
			"chcp 65001",
			// "Active code page: 65001"を表示しないためのコマンド
			// 下記のコマンドは出力を捨てることが可能
			"|",
			"Out-Null",
			// おまけ①: 好みでコマンドを後ろに続ける
			";",
		],
	},
},

```

上記は、ターミナルが起動する際に実行されるものです。
なので、既にターミナルを起動している場合は、新しくターミナルを起動してください。
