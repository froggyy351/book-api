package com.bookmanager.book_api;

import jakarta.validation.constraints.NotBlank;

public class Book {

    //フィールド
    private int id;
    @NotBlank(message = "タイトルは必須です")
    private String title;
    @NotBlank(message = "著者は必須です")
    private String author;

    //引数なしコンストラクタ
    public Book(){
        
    }

    //Insert用コンストラクタ
    public Book(String title, String author){
        this.title = title;
        this.author = author;
    }

    //Select用コンストラクタ
    public Book(int id, String title, String author){
        this.id = id;
        this.title = title;
        this.author = author;
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

    //Setter
    //DBが採番するため(クライアントはセットしないため)、idのsetterは不要。

    public void setTitle(String title){
        this.title = title;
    }

    public void setAuthor(String author){
        this.author = author;
    }
}
