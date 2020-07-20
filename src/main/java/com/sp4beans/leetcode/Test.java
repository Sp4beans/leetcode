package com.sp4beans.leetcode;

import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

/**
 * @author wangjixin <wangjixin@kuaishou.com>
 * Created on 2020-05-13
 */
public class Test {

    public static class KV {
        private int x;

        public Type getX() {
            return null;
        }

        public void setX(int x) {

        }
    }

    public enum Type {
        A,
        B,
        C;
    }

    public static void main(String[] args) throws Exception {
        PropertyDescriptor[] pds = Introspector.getBeanInfo(KV.class).getPropertyDescriptors();
        for (PropertyDescriptor pd : pds) {
            Method writeMethod = pd.getWriteMethod();
            System.out.println(pd.getName() + ":" + ((writeMethod == null) ? "null" : writeMethod.getName()));
        }
    }
}

