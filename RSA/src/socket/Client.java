/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socket;

import gui.ClientGui;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ANHMATTROI
 */
public class Client 
{
    private Socket socket;
    private String server_name;
    private BufferedReader read_client;
    private PrintWriter write_client;
    private int port;
    private Thread thread_send, thread_receive;
    private boolean enable;
    private boolean connected;
    private ClientGui client_gui;
    
    public Client()
    {
        socket = null;
        server_name = "localhost";
        read_client = null;
        write_client = null;
        port = 9040;
        thread_send = null;
        thread_receive = null;
        enable = true;
        client_gui = null;
        connected = false;
    }
    
    public boolean ConnectToServer(String server_name, int port)
    {
        try 
        {
            this.server_name = server_name;
            this.port = port;
            socket = new Socket(server_name, port);
            read_client = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            write_client = new PrintWriter(socket.getOutputStream());
            connected = true;
            return true;
        } 
        catch (IOException ex) 
        {
            connected = false;
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public boolean getState()
    {
        return connected;
    }
    
    public void SendData(final String message)
    {
        thread_send = new Thread()
        {
            @Override
            public void run()
            {
                write_client.println(message);
                write_client.flush();
                System.gc();
            }
        };
        thread_send.start();
    }
    
    public void Receivable(boolean enable)
    {
        this.enable = enable;
    }
    
    public void setClientGui(ClientGui client_gui)
    {
        this.client_gui = client_gui;
    }
    
    public void ReceiveData()
    {
        thread_receive = new Thread(new Runnable()
        {
            private String message;
            
            @Override
            public void run()
            {
                while(enable)
                {
                    try
                    {
                        message = read_client.readLine();
                        client_gui.setReceivedData(message);
                    }
                    catch(Exception ex)
                    {
                        ex.printStackTrace();
                    }
                }
            }
        });
        thread_receive.start();
    }
    
    public void Finish()
    {
        try
        {
            enable = false;
            connected = false;
            socket.shutdownInput();
            socket.shutdownOutput();
            socket.close();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
}
