/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rsa;

/**
 *
 * @author ANHMATTROI
 */
public class Euclid 
{
    public Euclid(){}
    
    public int GCD(long a, long b)
    {
        if(a < 1 || b < 1) return -1;
        long remain = 0;
        while(b > 0)
        {
            remain = a % b;
            a = b;
            b = remain;
        }
        return (int)a;
    }
    
    public byte[] Binary(long number)
    {
        byte[] binary = null;
        binary = new byte[64];
        byte i = 0;
        while(number > 0)
        {
            binary[i] = (byte)(number % 2);
            number /= 2;
            i++;
        }
        byte[] array;
        if(i == 0) 
        {
            array = new byte[1];
            array[0] = 0;
            return array;
        }
        array = new byte[i];
        byte j = (byte)(i - 1);
        for(i--;i > -1; i--)
        {
            array[j - i] = binary[i];
            //System.out.println(array[i] + ": " + (i + 1));
        }
        return array;
    }
    
    public long ModOf(long number, long x, long mod)
    {
        //System.out.println("d = " + x + "; n = " + mod);
        //if(number < 0 || x < 0 || mod < 0) return -1;
        byte[] binary = Binary(x);
        //if(binary == null) return -1;
        int i, size;
        long p;
        i = 0;
        size = binary.length;
        p = 1;
        for(i = 0; i < size; i++)
        {
            p = p * p;
            p = p % mod;
            if(binary[i] == 1)
            {
                p = p * number;
                p = p % mod;
            }
        }
        //System.out.println("p1 = " + p);
        return (int)p;
    }
    
    public long ModReserve(long number, long mod)
    {
        long a1, a2, a3;
        long b1, b2, b3;
        long t1, t2, t3;
        long q;
        q = 0;
        a1 = 1;
        a2 = 0;
        a3 = mod;
        b1 = 0;
        b2 = 1;
        b3 = number;
        while(b3 > 1)
        {
            q = a3 / b3;
            
            t1 = b1;
            t2 = b2;
            t3 = b3;
            
            b1 = a1 - q * b1;
            b2 = a2 - q * b2;
            b3 = a3 - q * b3;
            
            a1 = t1;
            a2 = t2;
            a3 = t3;
        }
        if(b3 != 1) b2 = -1;
        else if(b2 < 0) b2 = -1;
        return b2;
    }
}
