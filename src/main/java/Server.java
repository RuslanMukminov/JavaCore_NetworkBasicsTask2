import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static boolean checkCity(String serverCity, String userCity) {
        char chServer = serverCity.charAt(serverCity.length() - 1);
        char chUser = userCity.charAt(0);
        return chServer == chUser;
    }

    public static void main(String[] args) {
        String city = null;
        int port = 8989;
        try (ServerSocket serverSocket = new ServerSocket(port);) { // стартуем сервер один(!) раз
            while (true) { // в цикле(!) принимаем подключения
                try (Socket socket = serverSocket.accept();
                     PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                     BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))
                ) {
                    if (city == null) {
                        out.println("???");
                        city = in.readLine();
                        out.println("OK");
                        continue;
                    }
                    out.println(city);
                    String userCity = in.readLine();
                    if (checkCity(city, userCity)) {
                        city = userCity;
                        out.println("OK");
                    } else {
                        out.println("NOT OK");
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Не могу стартовать сервер");
            e.printStackTrace();
        }
    }
}
