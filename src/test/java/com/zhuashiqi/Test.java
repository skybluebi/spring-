package com.zhuashiqi;

import java.io.*;

public class Test {
    public static void main(String[] args) throws Exception {
        Iphone iphone = new Iphone();
       new LinPhone(new SmsPhone(iphone)).call();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("D://StudentInfo - 副本.txt")));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File("D://fa.txt")));

        int lenth=0;
        char[] chars=new char[1024];
        while ((lenth=bufferedReader.read())!=-1){
            bufferedWriter.write(bufferedReader.readLine());
            bufferedWriter.newLine();
        }
        bufferedReader.close();
        bufferedWriter.close();
    }
}
