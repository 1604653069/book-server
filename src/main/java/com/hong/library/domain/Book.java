package com.hong.library.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@TableName("tb_book")
public class Book {
    private Long id;
    private String cover;
    private String title;
    private String author;
    private String date;
    private String press;
    private String abs;
    private double score;
}
