package com.java.designpattern.abstractfactory;

//抽象工厂模式
public class AbstractFactory {
    public static void main(String args[]) {
        IFactory iFactory = new BenzFactory();

        iFactory.creatFactory(IFactory.FACTORY_TYPE.BENZ_FACTORY).createBike().run();
        iFactory.creatFactory(IFactory.FACTORY_TYPE.BENZ_FACTORY).createCar().run();

        System.out.println();

        iFactory = new BmwFactory();
        iFactory.creatFactory(IFactory.FACTORY_TYPE.BMW_FACTORY).createCar().run();
        iFactory.creatFactory(IFactory.FACTORY_TYPE.BMW_FACTORY).createBike().run();

        System.out.println();

        iFactory = new AudiFactory();
        iFactory.creatFactory(IFactory.FACTORY_TYPE.AUDI_FACTORY).createCar().run();
        iFactory.creatFactory(IFactory.FACTORY_TYPE.AUDI_FACTORY).createBike().run();
    }

}

//抽象产品 car
interface ICar {
    void run();
}

//抽象产品 bike
interface IBike {
    void run();
}

//具体产品 奔驰
class BenzCar implements ICar {
    @Override
    public void run() {
        System.out.println("奔驰 car");
    }
}

class BmwCar implements ICar {
    @Override
    public void run() {
        System.out.println("宝马 car");
    }
}

class AudiCar implements ICar {
    public void run() {
        System.out.println("奥迪 car");
    }
}

class BenzBike implements IBike {
    @Override
    public void run() {
        System.out.println("奔驰 bike");
    }
}

class BmwBike implements IBike {
    @Override
    public void run() {
        System.out.println("宝马 bike");
    }
}

class AudiBike implements IBike {
    public void run() {
        System.out.println("奥迪 bike");
    }
}

//抽象工厂
abstract class IFactory {

    enum FACTORY_TYPE {BENZ_FACTORY, BMW_FACTORY, AUDI_FACTORY}

    ;

    abstract ICar createCar();

    abstract IBike createBike();

    IFactory creatFactory(FACTORY_TYPE factoryType) {
        IFactory iFactory = null;
        switch (factoryType) {
            case BMW_FACTORY:
                iFactory = new BmwFactory();
                break;
            case BENZ_FACTORY:
                iFactory = new BenzFactory();
                break;
            case AUDI_FACTORY:
                iFactory = new AudiFactory();
                break;
            default:
                break;
        }

        return iFactory;
    }

}

class BenzFactory extends IFactory {
    ICar createCar() {
        return new BenzCar();
    }

    IBike createBike() {
        return new BenzBike();
    }
}

class BmwFactory extends IFactory {
    ICar createCar() {
        return new BmwCar();
    }

    IBike createBike() {
        return new BmwBike();
    }
}

class AudiFactory extends IFactory {
    ICar createCar() {
        return new AudiCar();
    }

    IBike createBike() {
        return new AudiBike();
    }
}