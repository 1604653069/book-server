package com.hong.library.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hong.library.domain.Book;
import com.hong.library.domain.Category;
import com.hong.library.domain.PageModel;
import com.hong.library.mapper.CategoryMapper;
import com.hong.library.service.BookService;
import com.hong.library.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {
    @Autowired
    BookService bookService;

    @Override
    public PageModel<Book> getBooksByCategoryId(Long id, Long currentPage, Long size) {
        return bookService.getBookByCategoryId(id,currentPage,size);
    }
}
