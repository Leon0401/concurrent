package com.stark.concurrent.lombok;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @auther leon
 * @create 2019/4/23 21:07
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors
public class Book {
    private Double price;
    private Integer number;

}
