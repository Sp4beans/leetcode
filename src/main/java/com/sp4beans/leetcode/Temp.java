package com.sp4beans.leetcode;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author wangjixin <wangjixin@kuaishou.com>
 * Created on 2020-08-20
 */
public class Temp {

    public static void main(String[] args) throws Exception {
        test3();
    }

    public static void test3() throws Exception {

        Pattern p = Pattern.compile("(liveStreamId|live_streamid)=(.*?)(&|$)");

        String line = "live_streamid=EMuZPapg55o";
        Matcher m = p.matcher(line);
        while (m.find()) {
            String trigger = m.group(2);
            System.out.println(trigger);
        }
    }

}
