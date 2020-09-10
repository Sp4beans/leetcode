package com.sp4beans.leetcode;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.net.URI;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.tools.DiagnosticCollector;
import javax.tools.FileObject;
import javax.tools.ForwardingJavaFileManager;
import javax.tools.JavaCompiler;
import javax.tools.JavaFileManager;
import javax.tools.JavaFileObject;
import javax.tools.SimpleJavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

/**
 * @author wangjixin <wangjixin@kuaishou.com>
 * Created on 2020-09-09
 */
public class Example {

    private String fullClassName;
    private String sourceCode;
    private Map<String, MyByteJavaFileObject> javaFileObjectMap = new ConcurrentHashMap<>();

    public void compile() {
        // 获取JavaCompiler
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        // 诊断信息收集
        DiagnosticCollector<JavaFileObject> diagnosticsCollector = new DiagnosticCollector<>();

        // 获取标准的内容管理器
        StandardJavaFileManager standardFileManager = compiler.getStandardFileManager(diagnosticsCollector, null, null);
        // 自定义的内容管理器，负责将编译后的字节码存储在MyByteJavaFileObject中
        JavaFileManager javaFileManager = new MyStringJavaFileManager(standardFileManager);

        // 构造源代码对象
        JavaFileObject javaFileObject = new MyStringJavaFileObject(fullClassName, sourceCode);

        List<String> options = new ArrayList<>();
        options.add("-classpath");
        StringBuilder sb = new StringBuilder();
        URLClassLoader urlClassLoader = (URLClassLoader) Thread.currentThread().getContextClassLoader();
        for (URL url : urlClassLoader.getURLs()) {
            sb.append(url.getFile()).append(File.pathSeparator);
        }
        options.add(sb.toString());

        // 获取一个编译任务
        JavaCompiler.CompilationTask task = compiler.getTask(null, javaFileManager, diagnosticsCollector, options, null,
                Arrays.asList(javaFileObject));

        // 执行编译过程
        boolean compileSuccess = task.call();
    }

    public void run() throws Exception {
        // 初始化类加载器
        MyClassLoader classLoader = new MyClassLoader(Thread.currentThread().getContextClassLoader());

        // 获取MyClass
        Class<?> myClass = classLoader.loadClass(fullClassName);

        // 获取入口方法
        Method main = myClass.getMethod("main");

        main.invoke(myClass.newInstance());
    }

    private class MyClassLoader extends ClassLoader {

        public MyClassLoader(ClassLoader parent) {
            super(parent);
        }

        @Override
        protected Class<?> findClass(String name) throws ClassNotFoundException {
            MyByteJavaFileObject fileObject = javaFileObjectMap.get(name);
            if (fileObject != null) {
                byte[] bytes = fileObject.getCompiledBytes();
                return defineClass(name, bytes, 0, bytes.length);
            }
            try {
                return ClassLoader.getSystemClassLoader().loadClass(name);
            } catch (Exception e) {
                return super.findClass(name);
            }
        }
    }


    private class MyStringJavaFileObject extends SimpleJavaFileObject {
        //等待编译的源码字段
        private String contents;

        //java源代码 => StringJavaFileObject对象 的时候使用
        public MyStringJavaFileObject(String className, String contents) {
            super(URI.create("string:///" + className.replaceAll("\\.", "/") + Kind.SOURCE.extension), Kind.SOURCE);
            this.contents = contents;
        }

        //字符串源码会调用该方法
        @Override
        public CharSequence getCharContent(boolean ignoreEncodingErrors) throws IOException {
            return contents;
        }
    }

    private class MyByteJavaFileObject extends SimpleJavaFileObject {
        //存放编译后的字节码
        private ByteArrayOutputStream outPutStream;

        public MyByteJavaFileObject(String className, Kind kind) {
            super(URI.create("string:///" + className.replaceAll("\\.", "/") + Kind.SOURCE.extension), kind);
        }

        //StringJavaFileManage 编译之后的字节码输出会调用该方法（把字节码输出到outputStream）
        @Override
        public OutputStream openOutputStream() {
            outPutStream = new ByteArrayOutputStream();
            return outPutStream;
        }

        //在类加载器加载的时候需要用到
        public byte[] getCompiledBytes() {
            return outPutStream.toByteArray();
        }
    }

    private class MyStringJavaFileManager extends ForwardingJavaFileManager {
        MyStringJavaFileManager(JavaFileManager fileManager) {
            super(fileManager);
        }

        @Override
        public ClassLoader getClassLoader(Location location) {
            return super.getClassLoader(location);
        }

        //获取输出的文件对象，它表示给定位置处指定类型的指定类。
        @Override
        public JavaFileObject getJavaFileForOutput(Location location, String className, JavaFileObject.Kind kind,
                FileObject sibling) throws IOException {
            MyByteJavaFileObject javaFileObject = new MyByteJavaFileObject(className, kind);
            javaFileObjectMap.put(className, javaFileObject);
            return javaFileObject;
        }
    }
}
