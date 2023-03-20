package com.hong.library.controller;

import com.hong.library.domain.Book;
import com.hong.library.domain.Category;
import com.hong.library.domain.PageModel;
import com.hong.library.domain.Result;
import com.hong.library.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping("/list")
    public Result<List<Category>> getCategoryList() {
        return new Result<List<Category>>().success(categoryService.list());
    }

    @GetMapping("/{id}/books")
    public Result<PageModel<Book>> getBooksByCategoryId(@PathVariable("id") Long id, @RequestParam Long currentPage, @RequestParam Long size) {
        System.out.println("currentPage:"+currentPage);
        System.out.println("size:"+size);
        return new Result<PageModel<Book>>().success(categoryService.getBooksByCategoryId(id, currentPage,size));
    }
}
