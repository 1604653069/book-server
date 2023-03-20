package com.hong.library.controller;

import com.hong.library.domain.Book;
import com.hong.library.domain.PageModel;
import com.hong.library.domain.Result;
import com.hong.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping("/list/{keyword}")
    public Result<List<Book>> getBookListByKeyWord(@PathVariable("keyword") String keyword) {
        return new Result<List<Book>>().success(bookService.getBookListByKeyword(keyword));
    }

    @GetMapping("/list")
    public Result<PageModel<Book>> getBookPage(@RequestParam Long currentPage, @RequestParam Long size) {
        return new Result<PageModel<Book>>().success(bookService.getBookPages(currentPage, size));
    }
}
