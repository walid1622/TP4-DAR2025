package clientPackage;
import java.net.*;
import java.util.Scanner;

public class ClientUDP {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket();
        InetAddress serverAddress = InetAddress.getByName("localhost");
        Scanner sc = new Scanner(System.in);

        System.out.print("Entrez votre nom d'utilisateur : ");
        String username = sc.nextLine();

        while (true) {
            System.out.print("Message : ");
            String message = "[" + username + "] : " + sc.nextLine();
            byte[] data = message.getBytes();

            DatagramPacket paquet = new DatagramPacket(data, data.length, serverAddress, 1234);
            socket.send(paquet);
        }
    }
}

