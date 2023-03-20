package com.hong.library.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hong.library.domain.Book;
import com.hong.library.domain.PageModel;
import com.hong.library.domain.User;

import java.util.List;

public interface BookService extends IService<Book> {

    public PageModel<Book> getBookByCategoryId(Long id,Long current,Long size);

    public List<Book> getBookListByKeyword(String keyword);

    public PageModel<Book> getBookPages(Long current,Long size);


}
