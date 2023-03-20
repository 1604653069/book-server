package com.hong.library.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hong.library.domain.Book;
import com.hong.library.domain.Category;
import com.hong.library.domain.PageModel;


public interface CategoryService extends IService<Category> {


    public PageModel<Book> getBooksByCategoryId(Long id, Long currentPage, Long size);
}
