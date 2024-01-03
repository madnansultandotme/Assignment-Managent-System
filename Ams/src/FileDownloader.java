import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class FileDownloader {

    public static void main(String[] args) {
        String serverUrl = "http://localhost:8080/download"; // Replace with your server's URL
        String savePath = "downloaded_file.pdf"; // Path to save the downloaded file

        try {
            URL url = new URL(serverUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                InputStream inputStream = connection.getInputStream();
                OutputStream outputStream = new FileOutputStream(savePath);

                byte[] buffer = new byte[4096];
                int bytesRead;
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }

                inputStream.close();
                outputStream.close();

                System.out.println("File downloaded successfully!");

            } else {
                System.out.println("No file to download. Server replied HTTP code: " + responseCode);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
