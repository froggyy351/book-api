package com.bookmanager.book_api;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;

public class Book {

//フィールド
    //id
    private int id;

    //タイトル
    @NotBlank(message = "タイトルは必須です")
    private String title;
    
    //著者
    @NotBlank(message = "著者は必須です")
    private String author;

    //表紙画像URL
    private String thumbnail;

    //ステータス
    private String status;

    //メモ
    private String memo;

    //評価
    private Integer rating;

    //登録日
    private LocalDateTime createdAt;

    //引数なしコンストラクタ
    public Book(){
        
    }


//Getter
    public int getId(){
        return this.id;
    }

    public String getTitle(){
        return this.title;
    }

    public String getAuthor(){
        return this.author;
    }

    public String getThumbnail(){
        return this.thumbnail;
    }

    public String getStatus() {
        return status;
    }

    public String getMemo() {
        return memo;
    }

    public Integer getRating() {
        return rating;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }


//Setter
    public void setId(int id) {
        this.id = id;
    }
   
    public void setTitle(String title){
        this.title = title;
    }

    public void setAuthor(String author){
        this.author = author;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

}
