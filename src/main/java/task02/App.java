package task02;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;


public class App 
{
    public static void main( String[] args )throws Exception {
        final int port = 80;
        String emailAddress = "task02.chuklee.com";
        ObjectInputStream ois;
        ObjectOutputStream oos;
        DataInputStream dis;
        BufferedInputStream bis;
        try {
            ServerSocket ss = new ServerSocket(port);
            System.out.println("[SERVER] Waiting for a connection...");

            while(true){
                
                try {
                   Socket clientSocket = new Socket(emailAddress,port);
                   //Note: Get your outputStream first followed by InputStream!!!
                   oos = new ObjectOutputStream(clientSocket.getOutputStream());
                    ois = new ObjectInputStream(clientSocket.getInputStream());
                    String line = ois.readUTF();
                    StringBuilder sb = new StringBuilder();
                    while(!line.isBlank()){
                        sb.append(line +"\r\n");
                        line=ois.readUTF();                   
                    }

                    System.out.println(sb.toString());
                String requestId = line.split(" ")[0];
                // Request Id here!
                System.out.println("RequestId: " + requestId);
                String [] temp = line.split(" ");
                String[] listOfNumbers =temp[1].split(",");
                int sum=0;
                for(int i =0; i<=listOfNumbers.length;i++){
                    int number;
                    number = Integer.parseInt(listOfNumbers[i]);
                    sum += number;
                    Float average = 1.0f *sum /listOfNumbers.length;
                    //Question 3: Average of the list of numbers!
                    System.out.println(average);  
                    
                    oos.writeUTF(requestId);
                    oos.writeFloat(average);;
                    oos.writeUTF("TAN TIAN CAI KEVIN");
                    oos.writeUTF("kevinttc93@gmail.com");
                    oos.flush();
                    oos.close();
                }
                bis = new BufferedInputStream(clientSocket.getInputStream());
                dis = new DataInputStream(bis);
                String response2 = dis.readUTF();
                StringBuilder sb2 = new StringBuilder();
                while(!response2.isBlank()){
                    sb2.append(line +"\r\n");                   
                }
                if(sb2.toString() == "true"){
                    System.out.println("SUCESSS");
                    
                }
                else{
                System.out.println("Failed " + sb2);
                }
                dis.close();
                bis.close();
                ois.close();
                clientSocket.close();
                ss.close();       

                } catch (UnknownHostException uhe) {
    
                }
            }
         } catch (Exception e) {
            
        }

    }
}
