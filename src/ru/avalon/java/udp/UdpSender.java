package ru.avalon.java.udp;

import com.sun.xml.internal.bind.api.Bridge;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.UnknownHostException;

/**
 * Упражнение, направленное на выработку умений, связанных
 * с отправкой сообщений средствами протокола UDP.
 *
 * @author Daniel Alpatov
 */
public final class UdpSender {
    
    private static final int UDP_PORT = 11_248;
    private static BufferedReader br
            = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
             
        // 1. Формируем сообщение
        final String message = prepareMessage();
        // 2. Формируем адрес конечной точки.
        final SocketAddress address = prepareAddress();
        // 3. Формируем датаграмму.
        final DatagramPacket packet = pack(message);
        // 4. Устанавливаем адрес для пакета.
        packet.setSocketAddress(address);
        // 5. Создаём сокет
        DatagramSocket socket = createSocket();
        // 6. Отправляем сообщение
        socket.send(packet);
        // 7. Освобождаем ресурсы
        socket.close();
    }

    /**
     * Возвращает сообщение.
     *
     * @return текстовое сообщение.
     */
    private static String prepareMessage() throws IOException {
        /*
         * !TO DO Реализовать метод prepareMessage класса UdpSender
         */
        String message = br.readLine();
        return message;
    }

    /**
     * Возвращает адрес конечной точки взаимодействия.
     *
     * @return адрес конечной точки.
     */
    private static SocketAddress prepareAddress() throws UnknownHostException {
        /*
         * !TO DO Реализовать метод prepareAddress класса UdpSender
         */
        SocketAddress address = new InetSocketAddress(
                InetAddress.getLocalHost(), UDP_PORT);
        return address;
    }

    /**
     * Возвращает сокет, описывающий взаимодействие по протоколу UDP.
     *
     * @return сокет.
     * @throws IOException
     */
    private static DatagramSocket createSocket() throws IOException {
        /*
         * !TO DO Реализовать метод createSocket класса UdpSender
         */
        DatagramSocket socket = new DatagramSocket();
        return socket;
    }

    /**
     * Упаковывает текстовое сообщение в объект типа {@link DatagramPacket}.
     *
     * @param message строковое сообщение.
     *
     * @return экземпляр типа {@link DatagramPacket}.
     */
    private static DatagramPacket pack(String message) {
        /*
         * !TO DO Реализовать метод pack класса UdpSender
         */
        byte[] buf = message.getBytes();
        DatagramPacket packet = new DatagramPacket(buf, buf.length);
        return packet;
    }

}
