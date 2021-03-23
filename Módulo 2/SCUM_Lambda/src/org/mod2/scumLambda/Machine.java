package org.mod2.scumLambda;

public class Machine{

    public int compute(int num, MonoOperation mono) {
        return mono.square(num);
    }

    public <T>T compute(T num, T num2, BiOperation<T> biOps){
        return biOps.divide(num,num2);
    }


}
