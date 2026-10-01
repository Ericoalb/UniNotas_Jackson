package Unicotas;
import tools.jackson.databind.JsonNode;
import tools.jackson.databind.ObjectMapper;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

public class FaculdadeController implements HttpHandler {
    private FaculdadeService faculdadeService;

    private final ObjectMapper mapper = new ObjectMapper();

    public FaculdadeController(FaculdadeService faculdadeService)
    {
        this.faculdadeService = faculdadeService;
    }

    // método obrigatório que recebe TUDO que vem do Postman
    @Override
    public void handle(HttpExchange exchange) throws IOException
    {
        String method = exchange.getRequestMethod();
        try
        {
            if(method.equals("POST"))
            {
                FaculdadeEntity faculdade = mapper.readValue(exchange.getRequestBody(), FaculdadeEntity.class);
                faculdadeService.cadastrarFaculdadede(faculdade);
                enviarResposta(exchange, 201, "Faculdade salva com ID " + faculdade.getId() + "!");
            }
            else if (method.equals("GET"))
            {
                // 1. Pega a lista do Service
                ArrayList<FaculdadeEntity> listaFaculdade = faculdadeService.listarFaculdade();
                String resposta = mapper.writeValueAsString(listaFaculdade);
                enviarResposta(exchange, 200, resposta);
            }
            else if (method.equals("PUT"))
            {
                FaculdadeEntity dadosAtualizados = mapper.readValue(exchange.getRequestBody(), FaculdadeEntity.class);
                FaculdadeEntity faculdade = faculdadeService.buscarFaculdadeId(dadosAtualizados.getId());
                faculdadeService.atualizarFaculdade(faculdade, dadosAtualizados.getName(), dadosAtualizados.getCnpj());

                enviarResposta(exchange, 200, "Faculdade ID " + dadosAtualizados.getId() + " atualizada com sucesso!");
            }
            else if (method.equals("DELETE"))
            {
                JsonNode node = mapper.readTree(exchange.getRequestBody());
                int id = node.get("id").asInt();

                FaculdadeEntity faculdade = faculdadeService.buscarFaculdadeId(id);
                faculdadeService.removerFaculdade(faculdade);
                enviarResposta(exchange, 200, "Faculdade ID " + id + " excluida com sucesso!");
            }
        }
        catch (Exception e)
        {
            // Se der erro ao ler ou cortar o texto, ele cai aqui e envia a mensagem para o Postman
            e.printStackTrace();
            enviarResposta(exchange, 400, "Erro ao processar a requisicao JSON.");
        }


    }

    // Método  para devolver a resposta ao Postman
    private void enviarResposta(HttpExchange exchange, int code, String texto) throws IOException
    {
        exchange.sendResponseHeaders(code, texto.getBytes().length);
        OutputStream os = exchange.getResponseBody();
        os.write(texto.getBytes());
        os.close();
    }
}