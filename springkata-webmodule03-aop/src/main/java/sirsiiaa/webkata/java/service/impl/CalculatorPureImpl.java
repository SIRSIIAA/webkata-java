package sirsiiaa.webkata.java.service.impl;

import org.springframework.stereotype.Service;
import sirsiiaa.webkata.java.service.Calculator;

@Service
public class CalculatorPureImpl implements Calculator {

    @Override
    public int add(int i, int j) {

        int result = i + j;

        return result;
    }

    @Override
    public int sub(int i, int j) {

        int result = i - j;

        return result;
    }

    @Override
    public int mul(int i, int j) throws InterruptedException {

        int result = i * j;
        Thread.sleep(100);

        return result;
    }

    @Override
    public int div(int i, int j) {

        System.out.println("enter div");
        int result = i / j;
        System.out.println("after calculate");
        return result;
    }
}
