package com.bookmanager.book_api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.bookmanager.book_api.BookDAO;
import com.bookmanager.book_api.BookService;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {
    @Mock
    BookDAO dao;

    @InjectMocks
    BookService service;

    @Test
    void getAll_全件返すこと() {
        //Arrange：dao.finAll()が呼ばれたら2件のリストを返すよう設定

        Book book1 = new Book();                                                                                                                                                                                     
        book1.setId(1);                                                                                                                                                                                              
        book1.setTitle("Java入門");
        book1.setAuthor("田中太郎");
        
        Book book2 = new Book();
        book2.setId(2); 
        book2.setTitle("SQL基礎");                                                                                                                                                                                   
        book2.setAuthor("山本博");
        List<Book> mockBooks = List.of(book1, book2);

        when(dao.findAll()).thenReturn(mockBooks);

        //Act: テスト対象を実行
        List<Book> result = service.getAll();

        //Assert：結果を検証
        assertEquals(2, result.size());
        verify(dao, times(1)).findAll();
    }

    @Test
    void delete_存在するIDならtrueを返すこと() {
        when(dao.deleteById(1)).thenReturn(true);

        //Act: テスト対象を実行
        boolean result = service.delete(1);

        //Assert：結果を検証
        assertTrue(result);    
    }

    @Test
    void delete_存在しないIDならfalseを返すこと() {
        when(dao.deleteById(999)).thenReturn(false);

        //Act: テスト対象を実行
        boolean result = service.delete(999);

        //Assert：結果を検証
        assertFalse(result);
    }
}
