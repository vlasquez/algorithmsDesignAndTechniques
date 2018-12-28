package week2;

import java.math.BigInteger;

public class FibonacciModNumber {
    public static void main(String[] args) {
        long fibonacciNumber = 239 , mod = 10;
        //System.out.println(fibonacciNaiveSolution(fibonacciNumber));
        System.out.println(fibonacciModNumberNaive(fibonacciNumber, BigInteger.valueOf(mod)));
    }

    public static BigInteger fibonacciModNumberNaive(long n, BigInteger mod){

        long remainder = n%getPisanoPeriod(mod);

        BigInteger previous = BigInteger.ZERO;
        BigInteger current = BigInteger.ONE;
        BigInteger res;
        // n = n % 8;
        if(remainder==0){
            return BigInteger.ZERO;
        }
        if(remainder==1){
            return BigInteger.ONE;
        }

        for(long i =2; i<=remainder; ++i){
             res = (previous.add(current));
            previous = current;
            current = res;
        }
        return  current.mod(mod);

    }

    private static long getPisanoPeriod(BigInteger mod) {
        long q=mod.longValueExact();
        long a=0;
        long b=1;
        long c=0;
        long i;
        int count = 0;
        for (i=0; i<=(q*q)-1;i++){
            if (a==0 && b==1 && count > 0){
                break;
            }

            c=(a+b) % q;
            a=b % q;
            b=c % q;
            count = count + 1;
        }
        return count;
    }
}
