import java.text.SimpleDateFormat;
import java.util.Date;

public class Video {
	public String titulo;
	public String descricao;
	public int duracao; // em minutos
	public String categoria;
	public Date dataPublicacao;

	public Video(String titulo, String descricao, int duracao, String categoria, Date dataPublicacao) {

		if (titulo.isEmpty() || titulo == null) {
			throw new IllegalArgumentException("Título não pode ser nulo ou  estar vazio");
		}

		if (descricao.isEmpty() || descricao == null) {
			throw new IllegalArgumentException("Descrição não pode ser nula ou  estar vazia");
		}

		if (categoria.isEmpty() || categoria == null){
			throw new IllegalArgumentException("Categoria não pode ser nula ou  estar vazia");
		}

		if (duracao <= 0) {
			throw new IllegalArgumentException("A duração do vídeo precisa ser maior que 0");
		}

		this.titulo = titulo;
		this.descricao = descricao;
		this.duracao = duracao;
		this.categoria = categoria;
		this.dataPublicacao = dataPublicacao;
	}

	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return titulo + ";" + descricao + ";" + duracao + ";" + categoria + ";" + sdf.format(dataPublicacao);
	}

	public static Video fromString(String linha) {
		try {
			String[] partes = linha.split(";");
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			return new Video(partes[0], partes[1], Integer.parseInt(partes[2]), partes[3], sdf.parse(partes[4]));
		} catch (Exception e) {
			return null; // Ignora erros de parsing
		}
	}
}