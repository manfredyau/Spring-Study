package com.yau.diy;

import org.springframework.stereotype.Component;

@Component
public class DiyPointCut {
    public void before() {
        System.out.println("==============Before==============");
    }

    public void after() {
        System.out.println("==============After==============");
    }
}
