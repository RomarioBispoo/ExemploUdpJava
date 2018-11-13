package br.ufs.dcomp.ExemploUdpJava; 

import java.net.*;

/*
    Alguns comandos úteis:
            cd Pasta do projeto. e.g cd ExemploUdpjava
            mvn compile 
            java -cp target/classes/ "um espaco em branco" digitar tab continuamente :D"
*/

public class AppUDP2 {

    public static void main(String[] args) throws SocketException {
        try{

            
            
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
        
        } catch (Exception e){
            System.out.println(e.getMessage());
        }    
        
    }
}