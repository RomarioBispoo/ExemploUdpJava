package br.ufs.dcomp.ExemploUdpJava;
import java.util.*;
import java.net.*;

public class AppUDP1 {

    public static void main(String[] args) throws SocketException {
        try{
            
            System.out.print("[ Alocando porta UDP      ..................  ");
    	    DatagramSocket socket = new DatagramSocket(10000);
            System.out.println("[OK] ]"); 
            System.out.println("insira a msg")
            Scanner sc = new Scanner (System.in);
            String msg = sc.nextLine();
            //String msg = "Olá!!!";
            
            byte[] msg_buf = msg.getBytes();
            int msg_size = msg_buf.length;
            InetAddress destination_address = InetAddress.getLocalHost();
            int destination_port = 20000; 

            System.out.print("[ Montando datagrama UDP  ..................  ");
            DatagramPacket pack = new DatagramPacket(msg_buf, msg_size, destination_address, destination_port);
            System.out.println("[OK] ]");
            
            System.out.print("[ Enviando datagrama UDP  ..................  ");
            socket.send(pack);
            System.out.println("[OK] ]");
           
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
            
            System.out.println("  Mensagem:             "+received_msg);
            System.out.println("  Endereço de origem:   "+origin_address.getHostAddress());
            System.out.println("  Porta de origem:      "+origin_port);
            
        
        } 
        catch (Exception e){
            System.out.println(e.getMessage());
        }    
        
    }
   }