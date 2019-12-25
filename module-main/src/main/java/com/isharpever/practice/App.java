package com.isharpever.practice;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public class App {

    public static void main(String[] args) {
        URL urlCommon = null;
        try {
            urlCommon = new URL("file:///F:\\tmp\\");
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return;
        }
        ClassLoader clCommon = new URLClassLoader(new URL[] {urlCommon});

        URL urlA = null;
        try {
            urlA = new URL("file:///F:/tmp/A/module-a-1.0.0-SNAPSHOT.jar");
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return;
        }
        ClassLoader clA = new URLClassLoader(new URL[] {urlA}, clCommon);

        URL urlB = null;
        try {
            urlB = new URL("file:///F:/tmp/B/module-b-1.0.0-SNAPSHOT.jar");
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return;
        }
        ClassLoader clB = new URLClassLoader(new URL[] {urlB}, clCommon);

        // 公共模块
        Common common = new Common();

        // 内部使用A模块
        Thread.currentThread().setContextClassLoader(clA);
        common.print();

        // 内部使用B模块
        Thread.currentThread().setContextClassLoader(clB);
        common.print();
    }
}
