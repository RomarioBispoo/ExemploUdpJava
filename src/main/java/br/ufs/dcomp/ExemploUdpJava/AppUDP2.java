package br.ufs.dcomp.ExemploUdpJava; 

import java.net.*;
import java.util.*;
import java.lang.*;
/*
    Alguns comandos úteis:
            cd Pasta do projeto. e.g cd ExemploUdpjava
            mvn compile 
            java -cp target/classes/ "um espaco em branco" digitar tab continuamente :D"
*/

public class AppUDP2 {

    public static void main(String[] args) throws SocketException {
        try{
            while(true){
            System.out.print("[ Alocando porta UDP                  ..................  ");
    	    DatagramSocket socket = new DatagramSocket(20000);
            System.out.println("[OK] ]");

            byte[] buf = new byte[20]; // Este vetor de bytes vai ser usado para o pacote
            DatagramPacket pack = new DatagramPacket(buf, buf.length); // criação de um pacote vazio

            System.out.print("[ Aguardando recebimento de mensagem  ..................  ");
            socket.receive(pack); //operação bloqueante (enquanto não chegar nada, esse processo ficará esperando)
            System.out.println("[OK] ]");
            
            byte[] received_data = pack.getData();
            String received_msg = new String(received_data); 
            InetAddress origin_address = pack.getAddress();
            int origin_port = pack.getPort();
            
            if (received_msg == "cambio"){
                System.exit(0);
            }
            
            System.out.println("  Mensagem:             "+received_msg);
            System.out.println("  Endereço de origem:   "+origin_address.getHostAddress());
            System.out.println("  Porta de origem:      "+origin_port);
        
               // Parte do envio de msg
                
            System.out.print("[ Alocando porta UDP      ..................  ");
            System.out.println("[OK] ]");
            System.out.println("insira a msg");
            Scanner sc = new Scanner (System.in);
            String msg = sc.nextLine();
            
            byte[] msg_buf = msg.getBytes();
            int msg_size = msg_buf.length;
            InetAddress destination_address = InetAddress.getLocalHost();
            int destination_port = 10000; 

            System.out.print("[ Montando datagrama UDP  ..................  ");
            DatagramPacket pack1 = new DatagramPacket(msg_buf, msg_size, destination_address, destination_port);
            System.out.println("[OK] ]");
            
            if (msg == "cambio"){
                System.exit(0);
            }
            
            System.out.print("[ Enviando datagrama UDP  ..................  ");
            socket.send(pack1);
            System.out.println("[OK] ]");
            
                // Parte do envio de msg
            socket.close();    
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }    
        
    }
}