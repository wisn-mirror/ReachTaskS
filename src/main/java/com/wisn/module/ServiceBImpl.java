package com.wisn.module;

import org.springframework.stereotype.Component;

@Component
public class ServiceBImpl implements ServiceB {
    @Override
    public void printServiceB1() {
        System.out.println("printServiceB1");
    }

    @Override
    public void printServiceB2() {
        System.out.println("printServiceB2");
    }
}
