package com.zlq.base.time;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

/**
 * Created by liqing.zhan on 2017/2/23.
 */
public class Day {
    public static void main(String[] args) {
//        System.out.println(new Date());
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss");
        System.out.println(format.format(calendar.getTime()));

        format.setTimeZone(TimeZone.getTimeZone("GMT"));
        System.out.println(format.format(calendar.getTime()));

    }
}
