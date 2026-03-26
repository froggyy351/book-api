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
        List<Book> mockBooks = List.of(
            new Book(1, "Java入門", "田中太郎"),
            new Book(2, "SQL基礎", "山本博")
        );
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
