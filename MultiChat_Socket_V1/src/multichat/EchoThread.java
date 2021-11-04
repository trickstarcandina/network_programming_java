/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multichat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author TrungPT
 */
public class EchoThread extends Thread {

    protected Socket socket;

    ObjectOutputStream oos = null;
    ObjectInputStream ois = null;
    DataOutputStream os = null;
    DataInputStream is = null;

    public EchoThread(Socket clientSocket) {
        this.socket = clientSocket;

        try {
            os = new DataOutputStream(clientSocket.getOutputStream());
            oos = new ObjectOutputStream(clientSocket.getOutputStream());
            is = new DataInputStream(clientSocket.getInputStream());
            ois = new ObjectInputStream(clientSocket.getInputStream());
            
        } catch (IOException ex) {
            Logger.getLogger(EchoThread.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public void sendString(String str) { // gửi dữ liệu kiểu String đến server 
        if (socket != null && os != null) {
            try {
                os.writeUTF(str);
            } catch (UnknownHostException e) {
                System.err.println(e);
            } catch (IOException e) {
                System.err.println(e);
            }
        }
    }

    public String receiveString() { // nhận dữ liệu kiểu String từ server
        if (socket != null && is != null) {
            try {
                String responseStr;
                if ((responseStr = is.readUTF()) != null) {
                    return responseStr;
                }
            } catch (UnknownHostException e) {
                System.err.println(e);
            } catch (IOException e) {
                System.err.println(e);
            }
        }
        return null;
    }

    public void run() {
            String username = receiveString();
            System.out.println("User connected: " + username);
            
            Server.userList.add(username);
            
            while(true){
                String msgReceived = receiveString();
                if(msgReceived.isEmpty() || msgReceived.equals("disconnect")) break;

                System.out.println("Message received: " + msgReceived);
                
                switch(msgReceived){
                    case "getUser":
                        getUser();
                        break;
                    
                     
                }
            }
    }

    private void getUser() {
        try {
            oos.writeObject(Server.userList);
        } catch (IOException ex) {
            Logger.getLogger(EchoThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
