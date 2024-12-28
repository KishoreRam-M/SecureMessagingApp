package krm.net;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Server {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket(9999);
        byte[] receiveData = new byte[1024];
        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
        socket.receive(receivePacket);
        
        String clientMessage = new String(receivePacket.getData(), 0, receivePacket.getLength());
        System.out.println("Received from client: " + clientMessage);
        
        String response = "Vanakkam Da (Response from Server)";
        byte[] sendData = response.getBytes();
        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, receivePacket.getAddress(), receivePacket.getPort());
        socket.send(sendPacket);
        
        socket.close();
    }
}
