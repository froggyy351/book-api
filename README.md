# book-api

## 概要
  Spring Bootを学習するために作成した書籍管理APIです。<br>
  3層アーキテクチャ・バリデーション・例外ハンドリングなど、<br>
  実務で使われる設計パターンの習得を目的としています。
<br>

## 技術スタック
- Java 21
- Spring Boot 3.5.11
- H2 Database（インメモリDB）
- Spring Data JDBC
- Spring Validation
<br>

## 機能一覧

  | メソッド | URL | 説明 |
  |---|---|---|
  | GET | /books | 全件取得する |
  | GET | /books/{id} | 1件取得する |
  | POST | /books | 登録する |
  | PUT | /books/{id} | 更新する |
  | DELETE | /books/{id} | 削除 する|
<br>

## 起動方法
- mvn spring-boot:run　をターミナルから実行する
<br>

## 学んだこと
- Spring Bootの基本的なアノテーション

  | @ | 説明 |
  |---|---|
  | @SpringBootApplication | Spring Bootのメインクラスにつける |
  | @Repository | DAOクラスにつける |
  | @Service | ビジネスロジックを担当するクラスにつける |
  | @RestController | @Controller + @ResponseBodyを合わせたもの。<br>メソッドの戻り値をそのままJSON形式でレスポンスとして返してくれる |
  | @RequestMapping("/books") | URL全体の起点を定義する |
  | @GetMapping | HTTPメソッド：GETに対応したアノテーション |
  | @PostMapping | HTTPメソッド：POSTに対応したアノテーション |
  | @PutMapping | HTTPメソッド：PUTに対応したアノテーション |
  | @DeleteMapping | HTTPメソッド：DELETEに対応したアノテーション |
<br>
-　３層アーキテクチャ
各クラスの責務を分担させるために、３層アーキテクチャという設計手法を採用している。<br>
コードの再利用性・保守性が向上し、修正時の影響範囲が限定されるというメリットがある。<br>
<br>

```
プレゼンテーション層：@Controller（APIの入り口、リクエスト受付・レスポンス返却を担当する）
↓
ビジネスロジック層：@Service層（ビジネスロジックを担当する）
↓
データアクセス層：@Repository（DAOなど。DBアクセスを担当する）
```
