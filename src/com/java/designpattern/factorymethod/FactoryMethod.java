package com.java.designpattern.factorymethod;

//工厂方法模式
public class FactoryMethod {
    public static void main(String args[]) {
        IFactory iFactory;

        iFactory = new FactoryA();
        iFactory.produce().run();

        iFactory = new FactoryB();
        iFactory.produce().run();
    }
}

// 抽象产品
interface IProduct {
    void run();
}

// 抽象工厂
interface IFactory {
    IProduct produce();
}

// 具体产品 A
class ProductA implements IProduct {
    @Override
    public void run() {
        System.out.println("ProductA");
    }
}

// 具体产品 B
class ProductB implements IProduct {
    @Override
    public void run() {
        System.out.println("ProductB");
    }
}

// 工厂 A
class FactoryA implements IFactory {
    @Override
    public IProduct produce() {
        return new ProductA();
    }
}

// 工厂 B
class FactoryB implements IFactory {
    @Override
    public IProduct produce() {
        return new ProductB();
    }
}