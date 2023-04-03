import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
        // Consumir a API do IMDB para buscar os top 250 melhores filmes        
        String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
        
        var http = new clienteHttp();
        String json = http.buscaDados(url);

        // extrair os dados (título, imagem)
        var parser = new JsonParser();
        List<Map<String, String>> listaDeConteudos = parser.parse(json);

        // exibir dados
        for (Map<String,String> conteudo : listaDeConteudos) {
            String urlImagem = conteudo.get("image");
            String titulo = conteudo.get("title");

            InputStream inputStream = new URL(urlImagem).openStream();
            String nomeArquivo = "saida/" + titulo + ".png";

            var gerador = new GeradorDeFigurinhas();
            gerador.cria(inputStream, nomeArquivo);

            System.out.println(conteudo.get("title"));
            //System.out.println(conteudo.get("image"));
            //System.out.println(conteudo.get("imDbRating"));
            System.out.println();
        }
    }
}
