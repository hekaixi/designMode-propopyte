package com.hekx.designMode03.simpPropopyte;

import java.util.ArrayList;
import java.util.List;

/**
 * 原型模式的用法是针对对象进行复制，由于一些数据类型的特殊性，需要进行深、浅克隆的区分
 * <p>
 * 对于简单类型，可以通过赋值的方式进行赋值【浅克隆】
 * 但对于引用类型【数组等集合】如果只采用赋值的方式，会导致不同对象持有相同的引用，此时需要进行深克隆对对象元素进行复制【深克隆】
 */
public class ConcretePrototypeA implements Prototype {
    private int age;
    private String name;
    private List hobbies;

    @Override
    public Prototype clone() {
        ConcretePrototypeA concretePrototype = new ConcretePrototypeA();
        concretePrototype.setAge(this.age);
        concretePrototype.setName(this.name);
        concretePrototype.setHobbies(this.hobbies);
        return concretePrototype;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List getHobbies() {
        return hobbies;
    }

    public void setHobbies(List hobbies) {
        this.hobbies = hobbies;
    }

    @Override
    public String toString() {
        return "ConcretePrototypeA{" + "age=" + getAge() + ", name='" + getName() + '\'' + ", hobbies=" + getHobbies() + '}';
    }
}

class Client {
    private Prototype prototype;

    public Client(Prototype prototype) {
        this.prototype = prototype;
    }

    public Prototype startClone(Prototype concretePrototype) {
        return (Prototype) concretePrototype.clone();
    }
}

class PrototypeTest {
    public static void main(String[] args) {
        // 创建一个具体的需要克隆的对象
        ConcretePrototypeA concretePrototype = new ConcretePrototypeA();
        concretePrototype.setAge(18);
        concretePrototype.setName("prototype");
        List hobbies = new ArrayList<String>();
        concretePrototype.setHobbies(hobbies);
        System.out.println(concretePrototype);

        // 创建 Client 对象，准备开始克隆
        Client client = new Client(concretePrototype);
        ConcretePrototypeA concretePrototypeClone = (ConcretePrototypeA) client.startClone(concretePrototype);
        System.out.println(concretePrototypeClone);
        System.out.println("克隆对象中的引用类型地址值:" + concretePrototypeClone.getHobbies());
        System.out.println("原对象中的引用类型地址值:" + concretePrototype.getHobbies());
        System.out.println("对象地址比较:" + (concretePrototypeClone.getHobbies() == concretePrototype.getHobbies()));
    }
}