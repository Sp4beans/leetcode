package com.sp4beans.leetcode;

import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * @author wangjixin <wangjixin@kuaishou.com>
 * Created on 2020-08-20
 */
public class Temp {

    public static void main(String[] args) throws Exception {
        PipedOutputStream out = new PipedOutputStream();
        PipedInputStream input = new PipedInputStream();

        input.connect(out);
        new Thread(() -> {
            try {
                System.out.println("write:");
                for(int i = 0; i < 20; i++) {
                    String outData = "" + ( i + 1 );
                    Thread.sleep(1000);
                    out.write(outData.getBytes());
                }
                out.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                System.out.println("read:");
                byte[] byteArray = new byte[8];
                int readLength;
                while(-1 != (readLength = input.read(byteArray))) {
                    String newData = new String(byteArray, 0, readLength);
                    System.out.print(newData);
                }
                input.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }

}
