package org.mod2.scumLambda;

public class Sandbox {

    public static void main(String[] args) {

        Machine machine = new Machine();

        System.out.println(machine.compute(5,(n1)->n1*n1));

        System.out.println(machine.compute(10,2,(n1,n2)->n1/n2));

        System.out.println(machine.compute("hello ","world!",(n1,n2)->n1+n2));

    }
}
