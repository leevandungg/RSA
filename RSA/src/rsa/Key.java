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
public class Key 
{
    private long n;
    private long m;
   
    public Key()
    {
        m = 0;
        n = 0;
    }

    public void setN(long n) 
    {
        this.n = n;
    }

    public void setM(long m) 
    {
        this.m = m;
    }
    
    public long getN()
    {
        return n;
    }

    public long getM() 
    {
        return m;
    }
}
