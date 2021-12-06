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
public class RSA 
{
    private Key private_key;
    private Key public_key;
    private String base64 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";
    
    public RSA()
    {
        private_key = new Key();
        public_key = new Key();
    }
    
    public byte IndexInBase64(char c)
    {
        byte i;
        for(i = 0; i < 64; i++)
            if(base64.charAt(i) == c) break;
        return i;
    }
    
    public void CreateKey(int p, int q)
    {
        if(p == q) return;
        long n = p * q;
        long phi = (p - 1) * (q - 1);
        //calculate number e
        long e = phi / 2;
        long d = 0;
        Euclid ecl = new Euclid();
        while(e > 3)
        {
            if(ecl.GCD(e, phi) == 1)
            {
                d = ecl.ModReserve(e, phi);
                if(d > 0 && e != d && d < phi) break;
            }
            e--;
        }
        if(e < 4)
        {
            e = phi / 2 - 1;
            while(e < phi)
            {
                if(ecl.GCD(e, phi) == 1)
                {
                    d = ecl.ModReserve(e, phi);
                    if(d > 0 && e != d && d < phi) break;
                }
                e++;
            }
            if(e >= phi)
            {
                e = 0;
                d = 0;
                n = 0;
            }
        }
        
        public_key.setM(e);
        public_key.setN(n);
        
        private_key.setM(d);
        private_key.setN(n);
    }
    
    public String Encrypt(String plain_text, Key public_key)
    {
        if(plain_text == null) return null;
        if(plain_text.equals("")) return "";
        int size, length;
        int i, j;
        short p;
        Euclid ecl = new Euclid();
        long c;
        length = plain_text.length();
        byte[] cipher_byte = new byte[(int)length * 4];
        j = 0;
        for(i = 0; i < length; i++)
        {
            p = (short)plain_text.charAt(i);
            c = ecl.ModOf(p, public_key.getM(), public_key.getN());
            
            cipher_byte[j] = (byte)((c >> 24) & 0xff);
            j++;
            cipher_byte[j] = (byte)((c >> 16) & 0xff);
            j++;
            cipher_byte[j] = (byte)((c >> 8) & 0xff);
            j++;
            cipher_byte[j] = (byte)(c & 0xff);
            j++;
        }
        //base64
        length = cipher_byte.length;
        size = length / 3 * 3;
        byte k, temp;
        String cipher_text = "";
        for(i = 0; i < size;)
        {
            k = (byte)((cipher_byte[i] & 0xfc) >> 2);
            cipher_text += base64.charAt(k);
            
            k = (byte)((cipher_byte[i] & 0x03) << 4);
            i++;
            temp = (byte)((cipher_byte[i] & 0xf0) >> 4);
            k = (byte)(k | temp);
            cipher_text += base64.charAt(k);
            k = (byte)((cipher_byte[i] & 0x0f) << 2);
            
            i++;
            temp = (byte)((cipher_byte[i] & 0xc0) >> 6);
            k = (byte)(k | temp);
            cipher_text += base64.charAt(k);
            
            k = (byte)((cipher_byte[i] & 0x3f));
            cipher_text += base64.charAt(k);
            i++;
        }
        if(i < length)
        {
            k = (byte)((cipher_byte[i] & 0xf3) >> 2);
            cipher_text += base64.charAt(k);
            
            k = (byte)((cipher_byte[i] & 0x03) << 4);
            i++;
            if(i < length)
            {
                temp = (byte)((cipher_byte[i] & 0xf0) >> 4);
                k = (byte)(k | temp);
                cipher_text += base64.charAt(k);
                k = (byte)((cipher_byte[i] & 0x0f) << 2);
                cipher_text += base64.charAt(k);
            }
            else
            {
                cipher_text += base64.charAt(k);
            }
        }
        return cipher_text;
    }
    
    public String Decrypt(String cipher_text, Key private_key)
    {
        int size;
        int length_byte, length_text;
        byte[] cipher_byte;
        int i, j;
        byte k, temp;
        length_text = cipher_text.length();
        length_byte = length_text * 3 / 4;
        size = (length_text * 3) % 4;
        if(size > 2) size = 2;
        length_byte += size;
        cipher_byte = new byte[(int)length_byte];
        j = 0;
        size = length_text / 4 * 4;
        for(i = 0; i < size;)
        {
            k = IndexInBase64(cipher_text.charAt(i));
            cipher_byte[j] = (byte)(k << 2);
            
            i++;
            k = IndexInBase64(cipher_text.charAt(i));
            temp = (byte)((k & 0x30) >> 4);
            cipher_byte[j] = (byte)(cipher_byte[j] | temp);
            j++;
            cipher_byte[j] = (byte)((k & 0x0f) << 4);
            
            i++;
            k = IndexInBase64(cipher_text.charAt(i));
            temp = (byte)((k & 0x3c) >> 2);
            cipher_byte[j] = (byte)(cipher_byte[j] | temp);
            j++;
            cipher_byte[j] = (byte)((k & 0x03) << 6);
            
            i++;
            k = IndexInBase64(cipher_text.charAt(i));
            k = (byte)(k & 0x3f);
            cipher_byte[j] = (byte)(cipher_byte[j] | k);
            j++;
            i++;
        }
        if(i < length_text)
        {
            k = IndexInBase64(cipher_text.charAt(i));
            cipher_byte[j] = (byte)(k << 2);
            
            i++;
            if(i < length_text)
            {
                k = IndexInBase64(cipher_text.charAt(i));
                temp = (byte)(k & 0x30 >> 4);
                cipher_byte[j] = (byte)(cipher_byte[j] | temp);
                j++;
                cipher_byte[j] = (byte)(k & 0x0f << 4);
            }
            
            i++;
            if(i < length_text)
            {
                k = IndexInBase64(cipher_text.charAt(i));
                temp = (byte)(k & 0x3f >> 2);
                cipher_byte[j] = (byte)(cipher_byte[j] | temp);
                j++;
                cipher_byte[j] = (byte)(k & 0x03 << 6);
            }
        }
        //decryption
        Euclid ecl = new Euclid();
        long p;
        long m;
        short u;
        String plain_text = "";
        size = length_byte / 4 * 4;
        for(i = 0; i < size;)
        {
            p = cipher_byte[i] & 0xff;
            p = p << 24;
            
            i++;
            m = cipher_byte[i] & 0xff;
            m = m << 16;
            p = p | m;
            
            i++;
            m = cipher_byte[i] & 0xff;
            m = m << 8;
            p = p | m;
            
            i++;
            m = cipher_byte[i] & 0xff;
            p = p | m;
            
            m = ecl.ModOf(p, private_key.getM(), private_key.getN());
            u = (short)(m & 0xffff);
            plain_text += (char)u;
            
            i++;
        }
        if(i < length_byte)
        {
            p = cipher_byte[i] & 0xff;
            p = p << 24;
            
            i++;
            if(i < length_byte)
            {
                m = cipher_byte[i] & 0xff;
                m = m << 16;
                p = p | m;
                
                i++;
                if(i < length_byte)
                {
                    m = cipher_byte[i] & 0xff;
                    m = m << 8;
                    p = p | m;
                }
            }
            
            m = ecl.ModOf(p, private_key.getM(), private_key.getN());
            u = (short)(m & 0xffff);
            plain_text += (char)u;
        }
        return plain_text;
    }
    
    public Key GetPublicKey()
    {
        return public_key;
    }
    
    public Key GetPrivateKey()
    {
        return private_key;
    }
    
    public void SetPublicKey(Key public_key)
    {
        this.public_key = public_key;
    }
    
    public void SetPrivateKey(Key private_key)
    {
        this.private_key = private_key;
    }
}
