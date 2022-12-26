package com.test;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Starting execution");
        new Options().importFile(args[0]);
 }
}
