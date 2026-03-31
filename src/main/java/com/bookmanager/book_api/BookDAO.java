package com.bookmanager.book_api;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BookDAO {
    private JdbcTemplate jdbcTemplate;
    
    public BookDAO(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    //ダブルクォート3つで囲むとテキストブロックとなり、改行が可能となる。
    //Java15以降の仕様。Java8の現場ではStringBuilder.appendを使って各行を文字列として連結させているぽい。
    public void setupTable(){
        String sql ="""
        CREATE TABLE IF NOT EXISTS books (
            id SERIAL PRIMARY KEY, 
            title VARCHAR(255) NOT NULL, 
            author VARCHAR(255), 
            thumbnail TEXT, 
            status VARCHAR(20) NOT NULL DEFAULT '未読', 
            memo TEXT, 
            rating INT CHECK (rating BETWEEN 1 AND 5), 
            created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP 
            )        
                """;
        jdbcTemplate.execute(sql);
    }   
    

    public boolean insert(Book book){
        //jdbcTemplate.updateは処理結果をintで行数返してくれる
        String sql = "INSERT INTO books (title, author, thumbnail, status, memo, rating) VALUES (?, ?, ?, ?, ?, ?)";
        int rows = jdbcTemplate.update(
            sql, 
            book.getTitle(), 
            book.getAuthor(),
            book.getThumbnail(),
            book.getStatus(),
            book.getMemo(),
            book.getRating()
        );
        return rows > 0;
    }

    public List<Book> findAll(){
        String sql = "SELECT * FROM books";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Book book = new Book();
            book.setId(rs.getInt("id"));
            book.setTitle(rs.getString("title"));
            book.setAuthor(rs.getString("author"));
            book.setThumbnail(rs.getString("thumbnail"));
            book.setStatus(rs.getString("status"));
            book.setMemo(rs.getString("memo"));
            book.setRating(rs.getObject("rating", Integer.class));
            book.setCreatedAt(rs.getObject("created_at", LocalDateTime.class));
            return book;
        });    
    }

    public boolean deleteById(int id){
        String sql = "delete from books where id = ?";
         int rows = jdbcTemplate.update(sql, id);
         return rows > 0;
    }

    public boolean updateById(int id, Book book){
        String sql = "update BOOKS set title = ?, author = ?, thumbnail = ?, status = ?, memo = ?, rating = ? where id = ?";
        int rows = jdbcTemplate.update(
            sql, 
            book.getTitle(), 
            book.getAuthor(), 
            book.getThumbnail(), 
            book.getStatus(), 
            book.getMemo(), 
            book.getRating(), 
            id
        );
        return rows > 0;
    }

    public Book findById(int id){
        String sql = "SELECT * FROM books where id = ?";
        return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
            Book book = new Book();
            book.setId(rs.getInt("id"));
            book.setTitle(rs.getString("title"));
            book.setAuthor(rs.getString("author"));
            book.setThumbnail(rs.getString("thumbnail"));
            book.setStatus(rs.getString("status"));
            book.setMemo(rs.getString("memo"));
            book.setRating(rs.getObject("rating", Integer.class));
            book.setCreatedAt(rs.getObject("created_at", LocalDateTime.class));
            return book;
        }, id);    
    }

}
