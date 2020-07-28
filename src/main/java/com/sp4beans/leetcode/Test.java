package com.sp4beans.leetcode;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @author wangjixin <wangjixin@kuaishou.com>
 * Created on 2020-05-13
 */
public class Test {

    public static void main(String[] args) throws Exception {

        File file1 = new File("/Users/wangjixin/Desktop/monthly_detail.xlsx");
        File file2 = new File("/Users/wangjixin/Desktop/monthly_detail_back.xlsx");

        byte[] buf = new byte[1024];

        File outputFile = new File("/Users/wangjixin/Desktop/test.zip");
        ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(outputFile));


        for (File file : Arrays.asList(file1, file2)) {
            zos.putNextEntry(new ZipEntry(file.getName()));
            FileInputStream fis = new FileInputStream(file);
            int len;
            while ((len = fis.read(buf)) > 0) {
                zos.write(buf, 0, len);
            }
            zos.closeEntry();
            fis.close();
        }

        zos.flush();
        zos.close();

    }

}

