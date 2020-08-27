package com.sp4beans.leetcode;

/**
 * @author wangjixin <wangjixin@kuaishou.com>
 * Created on 2020-08-20
 */
public class JavaRunner implements Runnable {

    private String name;
    private CustomStringJavaCompiler compiler;

    public JavaRunner(String name, CustomStringJavaCompiler compiler) {
        this.name = name;
        this.compiler = compiler;
    }

    public CustomStringJavaCompiler getCompiler() {
        return compiler;
    }

    public String getName() {
        return name;
    }

    @Override
    public void run() {
        try {
            System.out.println("start run");
            compiler.runMethod();
            System.out.println("runTakeTime: " + compiler.getRunTakeTime());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
