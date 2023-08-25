import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) throws IOException {
        //2. Solicitud de conexión
        Socket socket = new Socket("4.tcp.ngrok.io", 11591);
        System.out.println(socket.getPort());
        System.out.println("Conexión aceptada: "+socket.getInetAddress().getHostName());
        

        new Thread(()->{
            while(true){
                try {
                    byte[] bf = new byte[300];
                    socket.getInputStream().read(bf);
                    String rec = new String(bf, "UTF-8");
                    System.out.println(rec.trim());
                }catch (IOException ex){ex.printStackTrace();}
            }
        }).start();

        Scanner scanner = new Scanner(System.in);
        while (true){
            String msg = scanner.nextLine();
            socket.getOutputStream().write(msg.getBytes("UTF-8"));
        }

    }

    public void alfa(){
        print("Emparejamiento");
    }

}
