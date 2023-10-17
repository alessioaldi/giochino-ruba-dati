package com.example;

import java.io.BufferedReader;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

/**
 * Hello world!
 *
 */
public class App 
{

    public static void main( String[] args )
    {

        Random rand = new Random();
        try {
            System.out.println("Server avviato");
            ServerSocket server = new ServerSocket(3000);
            Socket s = server.accept();
            int n = rand.nextInt(101);
            int tent=0;

            System.out.println("in client si è ocnnesso");
            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            DataOutputStream out = new DataOutputStream(s.getOutputStream());

            do{
                
                int nRic = in.read();
                tent++;
                if(nRic>n){
                    out.writeByte(1);
                } else if(nRic<n){
                    out.writeByte(2);
                } else{
                    out.writeByte(3);
                }
                
                
                
            }while();

            out.writeByte(tent);
            server.close();
            s.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
    }
}
