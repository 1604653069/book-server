package com.hong.library.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PageModel<T> {
    /**
     * 总记录数
     */
    private long total;
    /**
     * 每页查询结果集
     */
    private List<T> rows = new ArrayList<>();
    /**
     * 总页数
     */
    private long page;

    /**
     * 当前页数
     */
    private long current;
    /**
     * 每页显示记录数
     */
    private long size;
    /**
     * 是否有下一页
     */
    private boolean hasNext;

    /**
     * 是否有上一页
     */
    private boolean hasPrevious;


}
