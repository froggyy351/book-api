package com.bookmanager.book_api;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BookDAO {
    private JdbcTemplate jdbcTemplate;
    
    public BookDAO(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public void setupTable(){
        String sql = "CREATE TABLE IF NOT EXISTS books (id INT AUTO_INCREMENT PRIMARY KEY, title VARCHAR(255) NOT NULL, author VARCHAR(255))";
        jdbcTemplate.execute(sql);
    }   
    

    public boolean insert(Book book){
        //jdbcTemplate.updateは処理結果をintで行数返してくれる
        String sql = "INSERT INTO books (title, author) VALUES (?, ?)";
        int rows = jdbcTemplate.update(sql, book.getTitle(), book.getAuthor());
        return rows > 0;
    }
}
