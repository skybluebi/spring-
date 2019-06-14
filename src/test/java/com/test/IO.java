package com.test;

import java.io.*;

public class IO {
    private static BufferedWriter bw;

    static {
        try {
            bw = new BufferedWriter(new FileWriter(new File("D://目录.txt")));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
//        testFileInputStream();
//        listFiles(new File("f://谷歌下载"),1);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(new File("D://a.jpg")));

    }

    private static void listFiles(File file,int level) throws UnsupportedEncodingException {
        String str="";
        for (int i = 1; i < level; i++) {
                str+="   ";
        }
        if (file.isDirectory()) {
            System.out.println(str+file.getName());
            try {
                bw.write(str+file.getName());
                bw.newLine();

            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                try {
                    bw.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            File[] files = file.listFiles();
            for (File f : files) {
                listFiles(f,level+1);
            }

        } else {
            System.out.println(str+file.getName());
            try {
                bw.write(str+file.getName());
                bw.newLine();

            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                try {
                    bw.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void testFileInputStream() throws IOException {
        File file = new File("D://img");
        File[] files = null;
        if (file.isDirectory()) {
            files = file.listFiles();
        }

        FileInputStream fis = new FileInputStream(files[0]);
        FileOutputStream fos = new FileOutputStream("D://img//a.jpeg");

        byte[] byt = new byte[1024];
        int lengh = 0;
        while ((lengh = fis.read(byt)) != -1) {
            fos.write(byt, 0, lengh);
        }
        fos.close();
        fos.close();
    }
}
