package com.hong.library.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hong.library.domain.Book;
import com.hong.library.domain.PageModel;
import com.hong.library.domain.User;
import com.hong.library.mapper.BookMapper;
import com.hong.library.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, Book> implements BookService {

    @Override
    public PageModel<Book> getBookByCategoryId(Long id, Long currentPage, Long size) {
        QueryWrapper<Book> queryWrapper = new QueryWrapper<>();
        Page<Book> page = new Page<>(currentPage, size);
        PageModel<Book> pageModel = new PageModel<>();
        if (id == 0) {
            return getListPageModel(queryWrapper, page, pageModel);
        }
        queryWrapper.eq("cid", id);
        return getListPageModel(queryWrapper, page, pageModel);
    }

    private PageModel<Book> getListPageModel(QueryWrapper<Book> queryWrapper, Page<Book> page, PageModel<Book> pageModel) {
        Page<Book> pageResult = baseMapper.selectPage(page, queryWrapper);
        System.out.println("pageResult:"+pageResult.getRecords().toString());
        pageModel.setTotal(pageResult.getTotal());
        pageModel.setCurrent(pageResult.getCurrent());
        pageModel.setSize(pageResult.getSize());
        pageModel.setTotal(pageResult.getTotal());
        pageModel.setRows(pageResult.getRecords());
        pageModel.setHasPrevious(pageResult.hasPrevious());
        pageModel.setHasNext(pageResult.hasNext());
        System.out.println("pageModel:" + pageModel.toString());
        return pageModel;
    }

    @Override
    public List<Book> getBookListByKeyword(String keyword) {
        QueryWrapper<Book> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("title", keyword).or().like("author", keyword);
        return baseMapper.selectList(queryWrapper);
    }

    @Override
    public PageModel<Book> getBookPages(Long current, Long size) {
        QueryWrapper<Book> queryWrapper = new QueryWrapper<>();
        Page<Book> page = new Page<>(current, size);
        Page<Book> resultPage = baseMapper.selectPage(page, queryWrapper);
        PageModel<Book> pageModel = new PageModel<>();
        pageModel.setPage(resultPage.getPages());
        pageModel.setCurrent(resultPage.getCurrent());
        pageModel.setSize(resultPage.getSize());
        pageModel.setRows(resultPage.getRecords());
        pageModel.setTotal(resultPage.getTotal());
        pageModel.setHasNext(resultPage.hasNext());
        pageModel.setHasPrevious(resultPage.hasPrevious());
        return pageModel;
    }
}
