package ru.avalon.java.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;


/**
 * Упражнение, на правленное на выработку умений, связанных с полученеим
 * сообщений, отправленных с использование протокола UDP.
 *
 * @author Daniel Alpatov
 */
public final class UdpReceiver {
    
    private static final int UDP_PORT = 11_248;

    public static void main(String[] args) throws IOException {
        
        
        
        // 1. Формиоуем буффер, для хранения получаемых данных.
        final byte[] buffer = prepareBuffer();
        // 2. Формируем пакет, на основе созданного буфера.
        final DatagramPacket packet = preparePacket(buffer);
        // 3. Выбираем порт, на который ожидается получение сообщения.
        final int port = 0;
        // 4. Формируем сокет, связанный с выбранным портом.
        final DatagramSocket socket = prepareSocket(port);
        // 5. Получаем сообщение.
        socket.receive(packet);
        // 6. На основании данных пакета формируем текстовое сообщение.
        final String message = getMessage(packet);
        // 7. Освобождаем ресурсы.
        socket.close();
    }

    /**
     * Возвращает буффер, который будет испопльзован для храрнения получаемых данных.
     *
     * @return двоичный массив.
     */
    private static byte[] prepareBuffer() {
        /*
         * TO DO Реализовать метод prepareBuffer класса UdpReceiver
         */
        byte[] buffer = new byte[4_096];
        return buffer;
    }

    /**
     * Упаковывает переданный двоичный массив (буффер) в экземпляр
     * типа {@link DatagramPacket}.
     *
     * @param buffer буффек, который будет использован пакетом для
     *               хранения получаемых данных.
     *
     * @return экземпляр типа {@link DatagramPacket}.
     */
    private static DatagramPacket preparePacket(byte[] buffer) {
        /*
         * TO DO Реализовать метод preparePacket класса UdpReceiver
         */
        DatagramPacket dp = new DatagramPacket(buffer, buffer.length);
        return dp;
    }

    /**
     * Возвращает сокет, связанный с указанным портом.
     *
     * @param port порт.
     *
     * @return сокет.
     */
    private static DatagramSocket prepareSocket(int port) throws SocketException {
        /*
         * TO DO Реализовать метод prepareSocket класса UdpReceiver
         */
        DatagramSocket socket = new DatagramSocket(port);
        return socket;
    }

    /**
     * Преобразует данные, содержащиеся в полученном пакете в текстовое
     * представление.
     *
     * @param packet пакет.
     *
     * @return строковое сообщение.
     */
    private static String getMessage(DatagramPacket packet) {
        /*
         * TO DO Реализовать метод getMessage класса UdpReceiver
         */
        String message = new String(packet.getData(), 0, packet.getLength());
        System.out.println("Received msg : " + message);
        return message;
    }

}
