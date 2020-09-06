package com.sp4beans.leetcode;

/**
 * @author wangjixin <wangjixin@kuaishou.com>
 * Created on 2020-05-13
 */
public class Test {

    public static void main(String[] args) throws Exception {

        System.setSecurityManager(new TempTaskSecurityManager());
        runMethod();

        runMethod();
    }

    public static void runMethod() throws Exception {
        String code = "package com.sp4beans.leetcode;\n"
                + "\n"
                + "/**\n"
                + " * @author wangjixin <wangjixin@kuaishou.com>\n"
                + " * Created on 2020-08-20\n"
                + " */\n"
                + "public class HelloWorld {\n"
                + "    public void run(StringBuilder out) throws Exception {\n"
                + "        int i = 0;\n"
                + "        while (i++ < 1000) {\n"
                + "            String data = \"\" + i;\n"
                + "            out.append(data);\n"
                + "            System.exit(0);\n"
                + "        }\n"
                + "    }\n"
                + "}";
        CustomStringJavaCompiler compiler = new CustomStringJavaCompiler(code);
        boolean res = compiler.compiler();
        if (res) {
            System.out.println("编译成功");
            System.out.println("compilerTakeTime：" + compiler.getCompilerTakeTime());

            compiler.runMethod();

            System.out.println(compiler.getRunResult());

            System.out.println("诊断信息：" + compiler.getCompilerMessage());

        } else {
            System.out.println("编译失败");
            System.out.println(compiler.getCompilerMessage());
        }
    }

}

