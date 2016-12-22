package com.zlq.base;

/**
 * Created by liqing.zhan on 2016/12/19.
 */
public class StringTest1 {
    public static void main(String[] args) {
        String url = "aaa&fromDate=2020&toDate=3333&limit=3838943";
        System.out.println(url.replaceAll("&fromDate=[^&]*", "&fromDate=2016-12-19").
                replaceAll("&toDate=[^&]*", "&toDate=2016-12-19").
                replaceAll("&limit=[^&]*", "&limit=0-60"));
    }
}
