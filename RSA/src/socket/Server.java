/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socket;

import gui.ServerGui;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ANHMATTROI
 */
public class Server 
{
    private ServerSocket server_socket;
    private Socket socket;
    private BufferedReader read_client;
    private PrintWriter write_client;
    private int port;
    private Thread thread_send, thread_receive;
    private boolean enable;
    private boolean connected;
    private ServerGui server_gui;
    
    public Server()
    {
        server_socket = null;
        socket = null;
        read_client = null;
        write_client = null;
        port = 9040;
        thread_send = null;
        thread_receive = null;
        enable = true;
        connected = false;
        server_gui = null;
    }
    
    public boolean ListeningClient(int port)
    {
        try 
        {
            this.port = port;
            server_socket = new ServerSocket(this.port, 36000);
            socket = server_socket.accept();
            read_client = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            write_client = new PrintWriter(socket.getOutputStream());
            connected = true;
            return true;
        } 
        catch (IOException ex) 
        {
            try 
            {
                server_socket.close();
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                connected = false;
            } 
            catch (IOException ex1) 
            {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        return false;
    }
    
    public boolean getState()
    {
        return connected;
    }
    
    public void Receivable(boolean enable)
    {
        this.enable = enable;
    }
    
    public void SetServerGui(ServerGui server_gui)
    {
        this.server_gui = server_gui;
    }
    
    public void SendData(final String message)
    {
        thread_send = new Thread()
        {
            public void run()
            {
                write_client.println(message);
                write_client.flush();
                System.gc();
            }
        };
        thread_send.start();
    }
    
    public void ReceiveData()
    {
        thread_receive = new Thread(new Runnable()
        {
            private String message;
            
            public void run()
            {
                while(enable)
                {
                    try
                    {
                        message = read_client.readLine();
                        server_gui.setReceivedData(message);
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
