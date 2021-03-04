package com.im.utils;

import cn.hutool.core.date.ChineseDate;
import cn.hutool.core.date.DateUtil;
import cn.hutool.extra.qrcode.QrCodeUtil;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

import java.util.Calendar;
import java.util.Date;

/**
 * @author zhaojinhui
 * @date 2021/2/19 18:17
 * @apiNote
 */
public class TestUtil {
    public static void main(String[] args) {
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        System.out.println(Calendar.SUNDAY == dayOfWeek || Calendar.SATURDAY == dayOfWeek);
    }
}
