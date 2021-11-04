package multichat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class TCPClient {

    Socket mySocket = null;
    ObjectOutputStream oos = null;
    ObjectInputStream ois = null;
    DataOutputStream os = null;
    DataInputStream is = null;
    static String ip;

    public void connection(String ip, int port) { // kết nối tới server
        try {
            mySocket = new Socket("192.168.100.5", 5679);
            ip = String.valueOf(mySocket.getLocalAddress());
            ois = new ObjectInputStream(mySocket.getInputStream());
            is = new DataInputStream(mySocket.getInputStream());
            oos = new ObjectOutputStream(mySocket.getOutputStream());
            os = new DataOutputStream(mySocket.getOutputStream());
        } catch (UnknownHostException e) {
            System.err.println(e);
        } catch (IOException e) {
            System.err.println(e);
        }
    }

    

    public void sendString(String str) { // gửi dữ liệu kiểu String đến server 
        if (mySocket != null && os != null) {
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
        if (mySocket != null && is != null) {
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
    
    
    public ArrayList<String> receiveUserList() { // nhận dữ liệu kiểu String từ server
        if (mySocket != null && ois != null) {
            try {
                ArrayList<String> userList;
                try {
                    if ((userList = (ArrayList) ois.readObject()) != null) {
                        return userList;
                    }
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(TCPClient.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (UnknownHostException e) {
                System.err.println(e);
            } catch (IOException e) {
                System.err.println(e);
            }
        }
        return null;
    }

    public void sendNumber(int a) { // gửi dữ liệu kiểu int đến server
        if (mySocket != null && os != null) {
            try {
                os.writeInt(a);
            } catch (UnknownHostException e) {
                System.err.println(e);
            } catch (IOException e) {
                System.err.println(e);
            }
        }
    }

    public int receiveNumber() { // nhận dữ liệu kiểu int từ server
        if (mySocket != null && is != null) {
            try {
                int a;
                if ((a = is.readInt()) != -1) {
                    return a;
                }
            } catch (UnknownHostException e) {
                System.err.println(e);
            } catch (IOException e) {
                System.err.println(e);
            }
        }
        return 0;
    }
    
    private void getAllUser() {
        
//        if (mySocket != null && os != null) {
//            try {
//                os.writeUtf(a);
//            } catch (UnknownHostException e) {
//                System.err.println(e);
//            } catch (IOException e) {
//                System.err.println(e);
//            }
//        }
    
    }

    public void close() { // ngắt kết nối tới server
        if (mySocket != null && oos != null && ois != null && os != null && is != null) {
            try {
                oos.close();
                ois.close();
                os.close();
                is.close();
                mySocket.close();
            } catch (UnknownHostException e) {
                System.err.println(e);
            } catch (IOException e) {
                System.err.println(e);
            }
        }
    }

    public static void main(String[] args) {
        TCPClient client = new TCPClient();
//        client.connection();
      
        
        
        
        client.getAllUser();
//        System.out.println(client.receiveString());
//        Student st = new Student("B18DCCN607", "Phạm Văn Thanh", ip, 10);
//        
//        client.sendStudent(st);
//        client.sendString("Phạm Văn Thanh");
//        client.sendString("B18DCCN607");
//        client.sendNumber(10);
//        
//        Answer answer = client.receiveStudent();
//        String maSV = answer.getStudent().getMaSV();
//        String hoTen = answer.getStudent().getHovaten();
//        String IP = answer.getStudent().getIP();
//        int group = answer.getStudent().getGroup();
//        client.sendString("Answer");
//        client.sendString(maSV);
        int a = 1;
        while(!client.mySocket.isClosed()){
            a = 0;
        }
        
            
        client.close();
    }

    
}