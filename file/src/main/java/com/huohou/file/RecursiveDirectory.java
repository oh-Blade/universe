package com.huohou.file;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.file.FileAppender;
import cn.hutool.core.io.file.FileWriter;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 递归读取指定文件夹并把路径名输出
 *
 * @author huohou
 */
public class RecursiveDirectory {

    public static void main(String[] args) {
        fileName("G:\\work\\workspace\\canaan\\shop.b-bug.org");

        File file = FileUtil.file("shop.csv");
        FileAppender appender = new FileAppender(file, 16, true);
        for (String s : list) {
          appender.append(s.substring(25).replaceAll("\\\\",","));
        }
        appender.flush();

    }

    public static List<String> list = new ArrayList<>();

    public static void fileName(String path) {
        File file = FileUtil.file(path);
        if (file.isDirectory()) {
            list.add(file.getPath());
            File[] ls = FileUtil.ls(path);
            for (File f : ls) {
                fileName(f.getPath());
            }
        } else {
            list.add(file.getPath());
        }
    }


}