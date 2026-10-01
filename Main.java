package Unicotas;
import com.sun.net.httpserver.HttpServer;
import java.net.InetSocketAddress;

public class Main {
    public static void main(String[] args) throws Exception {
        FaculdadeService service = new FaculdadeService();
        FaculdadeController controller = new FaculdadeController(service);
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        server.createContext("/faculdades", controller);
        server.setExecutor(null);
        server.start();
        System.out.println("Servidor rodando!");
        System.out.println("Teste no Postman acessando: http://localhost:8080/faculdades");
    }
}