package serverPackage;
import java.net.*;
import java.util.HashSet;
import java.util.Set;

public class ServeurUDP {
    static byte buffer[] = new byte[1024];
    private static Set<SocketAddress> clients = new HashSet<>();

    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket(1234);
        System.out.println("Serveur Multi-Clients actif sur le port 1234...");

        while (true) {
            DatagramPacket paquet = new DatagramPacket(buffer, buffer.length);
            socket.receive(paquet);

            int taille = paquet.getLength();
            String message = new String(paquet.getData(), 0, taille);

            System.out.println("Reçu de " + paquet.getSocketAddress() + " : " + message);

            clients.add(paquet.getSocketAddress());

            for (SocketAddress clientAddr : clients) {
                if (!clientAddr.equals(paquet.getSocketAddress())) {
                    DatagramPacket sendPacket = new DatagramPacket(
                            message.getBytes(), message.getBytes().length, clientAddr);
                    socket.send(sendPacket);
                }
            }
        }
    }
}
