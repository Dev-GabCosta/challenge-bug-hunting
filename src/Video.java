import service.ValidationService;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Video {
	private String titulo;
	private String descricao;
	private int duracao; // em minutos
	private String categoria;
	private Date dataPublicacao;

	public Video(String titulo, String descricao, int duracao, String categoria, Date dataPublicacao) {
		ValidationService.validateString(titulo);
		ValidationService.validateString(descricao);
		ValidationService.validateString(categoria);
		ValidationService.validateNumber(duracao);

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