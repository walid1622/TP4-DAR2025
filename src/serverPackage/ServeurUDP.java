package serverPackage;
import java.net.*;
public class ServeurUDP {
    static byte buffer[] = new byte[1024];

    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket(1234);
        System.out.println("Serveur lancé sur le port 1234...");

        while (true) {
            DatagramPacket paquet = new DatagramPacket(buffer, buffer.length);
            socket.receive(paquet);

            int taille = paquet.getLength();
            String message = new String(paquet.getData(), 0, taille);

            System.out.println("Message reçu de " + paquet.getSocketAddress() + " : " + message);
        }
    }
}
