# spring-boot-pokemon-autodoc 🦖📖

Spring BootでのAPI開発において、データベース設計書とAPI設計書を**完全に自動生成・同期**させるサンプルプロジェクトです。

ポケモンの情報をデータベースで管理し、REST APIで公開するシンプルなアプリケーションを題材に、開発効率とドキュメント品質を両立させるベストプラクティスを実装しています。

## 🌟 目玉機能
- **DB設計書の自動生成**: Flywayによるバージョン管理されたスキーマから、Markdown形式の設計書とER図を自動生成。
- **API設計書の自動生成**: SpringDocとOpenAPI 3.0により、最新のAPI定義（YAML/HTML）を自動生成。Swagger UIで対話的にAPI仕様を確認可能。
- **クリーンアーキテクチャ実装**: ドメイン駆動設計(DDD)の思想に基づき、レイヤー分離されたシンプルながら実践的な構成。

## 🛠 技術スタック
- **言語・フレームワーク**: Java 21 / Spring Boot 4.0.1
- **データベース**: PostgreSQL 16
- **データベース移行**: Flyway (SQL-based migration)
- **ドキュメント生成**:
    - [tbls](https://github.com/k1low/tbls) - DB設計書自動生成（Markdown/SVG形式）
    - [SpringDoc OpenAPI](https://springdoc.org/) - API設計書自動生成（OpenAPI 3.0）
- **ORM**: MyBatis
- **テスト**: 
    - Testcontainers (PostgreSQL) 
      - （未実装、検討中）
    - JUnit 5
- **その他**: Lombok, Docker Compose

## 📋 プロジェクト構造
```
src/main/java/com/example/
├── PokemonAutoDocApplication.java      # Spring Bootエントリーポイント
├── presentation/                        # API層（REST Controller）
│   ├── PokemonController.java           # ポケモンAPI
│   └── resource/
│       └── PokemonResponse.java         # APIレスポンス DTO
├── application/                         # ユースケース層
│   └── ViewPokemonAllUseCase.java       # ポケモン全件取得用ユースケース
├── domain/                              # ドメイン層
│   ├── model/
│   │   ├── Pokemon.java                 # ドメインモデル (Record)
│   │   └── PokemonFactory.java          # ファクトリー
│   ├── repository/
│   │   └── PokemonRepository.java       # リポジトリインターフェース
│   └── vo/                              # 値オブジェクト（id, name等）
└── infrastructure/                      # インフラ層
    └── ...                              # MyBatisマッパー実装等

src/main/resources/
├── application.yml                      # Spring Boot設定
├── db/migration/
│   ├── common/
│   │   └── V1__schema.sql              # DB初期スキーマ
│   └── test_data/                      # テスト用データ挿入スクリプト
└── mapper/
    └── PokemonMapper.xml                # MyBatisマッパー定義

docs/                                   # 自動生成されたドキュメント
├── api/
│   └── openapi.yaml                    # OpenAPI定義（YAML形式）
├── schema/                              # DB設計書
│   ├── public.pokemons.md              # テーブル定義書 / ER図（mermaid）
│   └── schema.json                     # スキーマ定義（JSON）
├── index.html                           # ドキュメント一覧
├── swagger.html                         # Swagger UI
└── schema.html                          # スキーマビューアー
```

## 🚀 セットアップ・実行方法

### 前提条件
- Java 21 以上
- Docker & Docker Compose（ローカル開発用）

### ローカル開発環境での実行
```bash
# 1. リポジトリをクローン
git clone https://github.com/your-repo/spring-boot-pokemon-autodoc.git
cd spring-boot-pokemon-autodoc

# 2. Docker Composeでデータベース起動
docker-compose up -d

# 3. アプリケーション起動
./gradlew bootRun
```

## 📖 生成されるドキュメント

### 1. API設計書 (`docs/api/openapi.yaml`)
- OpenAPI 3.0形式のAPI定義
- テスト実行時に自動生成
- Swagger UIで対話的に確認可能

### 2. DB設計書 (`docs/schema/`)
- テーブル定義書（Markdown）
- ER図（mermaid）
- スキーマ定義（JSON）
- Flywayで管理されたマイグレーションスクリプトから自動生成

## 🔄 ワークフロー例

1. **スキーマ変更** → `src/main/resources/db/migration/common/V*.sql` を追加
2. **dockerでコンテナ起動** → `compose up -d`でcompose.yamlに記載のサービスが起動
3. **ドキュメント自動更新** → Flyway実行後、tblsがDB設計書を生成
4. **API仕様追加** → Controllerに`@Operation`アノテーションを付与
5. **OpenAPI自動更新** → `./gradlew generateOpenApiDocs`でAPI設計書を生成
5. **ドキュメント確認** → `docs/` 配下のドキュメントを確認

## 💡 実装のポイント

- **クリーンアーキテクチャ**: presentation / application / domain / infrastructure に分離
- **ドメイン駆動設計**: 値オブジェクト（VO）を活用した型安全性
- **自動化**: CI/CD連携により、スキーマ/API仕様の更新を自動追跡

## 📝 今後の検討事項

### ⚠️ 未実装
- **Testcontainers統合**: 現在、テスト実行時のドキュメント自動生成はTestcontainersでの実装がまだ完了していません。将来的にテスト環境でのDB自動起動とドキュメント生成の自動化をやってみたい。

### 🔍 検討中
- **Liam ERD**: ER図生成ツール[Liam](https://liambx.com/)の導入を検討しています。より詳細で拡張性の高いER図を自動生成する可能性を探っています。

