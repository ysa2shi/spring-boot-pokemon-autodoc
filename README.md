# spring-boot-pokemon-autodoc 🦖📖

Spring BootでのAPI開発において、データベース設計書とAPI設計書を**完全に自動生成・同期**させるサンプルプロジェクトです。

## 🌟 目玉機能
- **DB設計書の自動化**: `Flyway` + `tbls` により、Markdown形式の設計書とER図を自動生成。
- **API設計書の自動化**: `SpringDoc (OpenAPI)` により、最新のAPI定義をJSON/HTMLで出力。
- **全自動運用**:
    - CI (Testcontainers) 内でDBを起動しドキュメントを更新。
    - 差分がある場合は自動でコミット＆PRにコメント。

## 🛠 技術スタック
- **Java 21 / Spring Boot 3.x**
- **Database**: PostgreSQL
- **Migration**: Flyway
- **Documentation**:
    - [tbls](https://github.com/k1low/tbls) (Database)
    - [SpringDoc OpenAPI](https://springdoc.org/) (API)
- **Test**: Testcontainers (Dockerを使わずにテスト＆ドキュメント生成)
- **CI/CD**: GitHub Actions

## 🚀 使い方
1. リポジトリをクローン
2. `./gralde test` を実行
3. `docs/` フォルダ配下に最新のドキュメントが生成されます