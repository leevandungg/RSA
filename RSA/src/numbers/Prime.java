/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package numbers;

import java.awt.List;

/**
 *
 * @author ANHMATTROI
 */
public class Prime 
{
    public Prime()
    {
        
    }
    
    public boolean IsPrime(long number)
    {
        if(number < 2) return false;
        if(number % 2 == 0 && number != 2) return false;
        long i = 3;
        double sqrt = Math.sqrt(number) + 1;
        while(i < sqrt)
        {
            if(number % i == 0) return false;
            i += 2;
        }
        return true;
    }
    
    public List ListPrime(long from_number, long to_number)
    {
        List list_prime = new List();
        if(from_number >= to_number) return list_prime;
        to_number++;
        while(from_number < to_number)
        {
            if(IsPrime(from_number))
                list_prime.add(String.valueOf(from_number));
            from_number++;
        }
        return list_prime;
    }
}
