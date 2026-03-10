package com.bookmanager.book_api;

import java.util.List;

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

    public List<Book> findAll(){
        String sql = "SELECT id, title, author FROM books";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            return new Book(
                rs.getInt("id"),
                rs.getString("title"),
                rs.getString("author")
            );
        });    
    }

    public boolean deleteById(int id){
        String sql = "delete from books where id = ?";
         int rows = jdbcTemplate.update(sql, id);
         return rows > 0;
    }
}
