import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.file.Files;

public class LocalFileServer {

    public static void main(String[] args) throws IOException {
        int serverPort = 8080; // Set your desired server port
        HttpServer server = HttpServer.create(new InetSocketAddress(serverPort), 0);
        server.createContext("/download", new DownloadHandler());
        server.setExecutor(null); // Use default executor
        server.start();

        System.out.println("Server is running on port " + serverPort);
    }

    static class DownloadHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            String filePath = "C:\\Users\\adnan\\Downloads\\Assign-3.pdf"; // Replace with your local file path
            File file = new File(filePath);

            if (!file.exists()) {
                String response = "File not found";
                exchange.sendResponseHeaders(404, response.length());
                OutputStream os = exchange.getResponseBody();
                os.write(response.getBytes());
                os.close();
                return;
            }

            exchange.sendResponseHeaders(200, file.length());
            OutputStream os = exchange.getResponseBody();
            Files.copy(file.toPath(), os);
            os.close();
        }
    }
}
