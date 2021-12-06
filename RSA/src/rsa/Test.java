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
public class Test 
{
    public static void main(String[] str)
    {
        Euclid ab = new Euclid();
        long x = ab.ModOf(104, 33531, 67592);
        System.out.println(x);
        
        RSA rsa = new RSA();
    }
}
