package org.vaskon.jpawork.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class ResBundleUtil {
    public static Map<String, String> getResBundle() {
        File file = new File("D:\\prog\\java\\progs\\work\\jpa-work\\data\\res_bundle.txt");

        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String s;
            while ((s = br.readLine()) != null) {
                sb.append(s);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        String s = sb.toString();
//        String s = "key1=value1, value11, value212312, key2=zupa1, zup2, keyy3=azaza";
        Map<String, String> map = new HashMap<>();
        try {
            boolean stop = false;
            while (!stop) {
                if (s.contains("=")) {
                    String key = s.substring(0, s.indexOf("="));
                    s = s.substring(s.indexOf("=") + 1);
                    String value;
                    if (s.contains("=")) {
                        String temp = s.substring(0, s.indexOf("="));
                        value = s.substring(0, temp.lastIndexOf(", "));
                        s = s.substring(temp.lastIndexOf(", ") + 2);
                    } else {
                        value = s;
                        stop = true;
                    }
                    map.put(key, value);
                } else {
                    if (s.isEmpty()) break;
                    else throw new RuntimeException("NOT OK! s = " + s);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return map;
    }

    public static void main(String[] args) {
        Map<String, String> resBundle = getResBundle();
        resBundle.entrySet().forEach(System.out::println);
    }
}

