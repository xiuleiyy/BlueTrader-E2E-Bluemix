package com.ibm.icap.tradelite.web;

import java.util.Random;

public class SessionFillerBean {
    private static int beanSize = 1; // in KB
    private static Random rand = new Random();
    private byte[] bytes = null;

    static {
        String temp = System.getProperty("trade.sessionBeanSize");
        if (temp != null) {
            beanSize = Integer.parseInt(temp);
        }

        System.out.println("SessionFillerBean:init() --> trade.sessionBeanSize = " + beanSize + " (KB)");
    }

    public SessionFillerBean() {
        bytes = new byte[beanSize * 1024];
        rand.nextBytes(bytes);

        //System.out.println("Bytes: " + new String(bytes));
        //System.out.println("Size (bytes): " + bytes.length);
    }

}
