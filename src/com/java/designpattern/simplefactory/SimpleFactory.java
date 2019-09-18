package com.java.designpattern.simplefactory;

import java.util.HashMap;

//演示简单工厂
public class SimpleFactory {
    public static void main(String args[]) throws Exception {
        Factory factory = new Factory();

        factory.produce("A").run();
        factory.produce("B").run();
        factory.produce("C").run();
    }
}

// 抽象产品
interface IProduct {
    void run();
}

// 具体产品 A
class ProductA implements IProduct {
    @Override
    public void run() {
        System.out.println("产品 A");
    }
}

// 具体产品 B
class ProductB implements IProduct {
    @Override
    public void run() {
        System.out.println("产品 B");
    }
}

// 具体产品 C
class ProductC implements IProduct {
    public void run() {
        System.out.println("产品 C");
    }
}

//工厂
class Factory {
	/*
	IProduct produce(String product) throws Exception{
		if(product.equals("A"))
			return new ProductA();
		else if(product.equals("B"))
			return new ProductB();
		throw new Exception("No Such Class");
	}
	*/

    IProduct produce(String product) throws Exception {
        switch (product) {
            case "A":
                return new ProductA();
            case "B":
                return new ProductB();
            case "C":
                return new ProductC();
            default:
                return null;
        }
    }

}