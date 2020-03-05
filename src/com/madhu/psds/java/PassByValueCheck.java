package com.madhu.psds.java;

public class PassByValueCheck {

    static class Foo {
        String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static void main(String[] args) {
        Foo foo = new Foo();
        foo.setName("Madhu");
        Foo foo1 = new Foo();
        foo1.setName("Sudhan");
        System.out.println(foo.getName());
        swap(foo, foo1);
        System.out.println(foo.getName());
        int a = 1;
        int b = 2;
        swap(a,b);
        System.out.print(a + " " + b);
    }

    static void swap(Foo a, Foo b) {
        Foo temp = a;
        a = b;
        b = temp;
    }

    static void swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
    }
}
