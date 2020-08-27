//package com.sp4beans.leetcode;
//
///**
// * @author wangjixin <wangjixin@kuaishou.com>
// * Created on 2020-05-13
// */
//public class Test {
//
//    public static void main(String[] args) throws Exception {
//
//        String code = "package com.sp4beans.leetcode;\n"
//                + "\n"
//                + "/**\n"
//                + " * @author wangjixin <wangjixin@kuaishou.com>\n"
//                + " * Created on 2020-08-20\n"
//                + " */\n"
//                + "public class HelloWorld {\n"
//                + "    public void run(StringBuilder out) throws Exception {\n"
//                + "        int i = 0;\n"
//                + "        while (i++ < 1000) {\n"
//                + "            String data = \"\" + i;\n"
//                + "            Thread.sleep(1000);\n"
//                + "            out.append(data);\n"
//                + "        }\n"
//                + "    }\n"
//                + "}";
//        CustomStringJavaCompiler compiler = new CustomStringJavaCompiler(code);
//        boolean res = compiler.compiler();
//        if (res) {
//            System.out.println("编译成功");
//            System.out.println("compilerTakeTime：" + compiler.getCompilerTakeTime());
//
//            Thread thread = new Thread(() -> {
//                try {
//                    while (!compiler.isFinished()) {
//                        Thread.sleep(1000);
//                        System.out.print("start result : ");
//                        String currentThreadName = Thread.currentThread().getName();
//                        System.out.print(currentThreadName + " : ");
//                        System.out.println(compiler.getRunResult());
//                    }
//                } catch (Exception e) {
//
//                }
//            });
//            thread.setDaemon(true);
//            thread.start();
//
//
//            try {
//                Thread.sleep(10000);
//                System.out.println("cancel future");
//                runner.getThread().interrupt();
//            } catch (Exception e) {
//
//            }
//
//            System.out.println(compiler.getRunResult());
//
//            System.out.println("诊断信息：" + compiler.getCompilerMessage());
//
//        } else {
//            System.out.println("编译失败");
//            System.out.println(compiler.getCompilerMessage());
//        }
//
//    }
//
//}
//
