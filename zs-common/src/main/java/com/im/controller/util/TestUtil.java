package com.im.controller.util;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

import java.util.Date;

/**
 * @author zhaojinhui
 * @date 2021/2/19 18:17
 * @apiNote
 */
public class TestUtil {
    public static void main(String[] args) {
        Table<Integer, Integer, Object> table = HashBasedTable.create();
        table.put(0, 0, "123");
        table.put(0, 1, 123);
        table.put(1, 0, new Date());
        table.put(1, 1, new int[]{1});
        System.out.println(table);
    }
}
