package org.example;

public class Calculator {
    public int a;
    public int b;

    public Calculator(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int add(){
        return a+b;
    }
    public int kurang(){
        return a-b;
    }
    public float bagi(){
        return a/b;
    }
    public int kali(){
        return a*b;
    }
}
