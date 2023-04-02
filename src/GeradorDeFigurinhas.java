import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
import java.net.URL;

import javax.imageio.ImageIO;

public class GeradorDeFigurinhas {
  
  public void cria() throws Exception {

    // leitura da imagem
    //BufferedImage imagemOriginal = ImageIO.read(new File("./entrada/filmes.jpg"));
    InputStream inputStream = new URL("https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies_1.jpg").openStream();
    BufferedImage imagemOriginal = ImageIO.read(inputStream);

    // criar nova imagem em memória com transparência e novo tamanho
    int largura = imagemOriginal.getWidth();
    int altura = imagemOriginal.getHeight();
    int novaAltura = altura + 200;
    BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

    // copiar a imagem original pra nova imagem (em memória)
    Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
    graphics.drawImage(imagemOriginal, 0, 0, null);

    // configurar a fonte
    var fonte = new Font(Font.SANS_SERIF, Font.BOLD, 70);
    graphics.setColor(Color.YELLOW);
    graphics.setFont(fonte);

    // escrever uma frase na imagem
    graphics.drawString("LEGALZINHO!", 120, novaAltura - 80);

    // escrever a nova imagem em um arquivo
    ImageIO.write(novaImagem, "png", new File("./saida/figurinha.png"));

  }

  public static void main(String[] args) throws Exception {
    var gerador = new GeradorDeFigurinhas();
    gerador.cria();
  }

}
