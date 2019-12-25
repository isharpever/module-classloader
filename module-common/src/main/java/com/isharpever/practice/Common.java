package com.isharpever.practice;

public class Common {
    public void print() {
        System.out.println("common");

        ClassLoader cl = Thread.currentThread().getContextClassLoader();
        try {
            Class<ISeparate> clazz = (Class<ISeparate>)cl.loadClass("com.isharpever.practice.Separate");
            clazz.newInstance().print();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
