package com.wisn.module;

import org.springframework.stereotype.Component;

@Component
public class ServiceAImpl implements ServiceA {
    @Override
    public void printServiceA1() {
        System.out.println("printServiceA1");
    }

    @Override
    public void printServiceA2() {
        System.out.println("printServiceA2");
    }
}
