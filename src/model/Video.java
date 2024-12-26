package model;

import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Video {
	private String titulo;
	private String descricao;
	private int duracao; // em minutos
	private String categoria;
	private Date dataPublicacao;

	public Video(String titulo, String descricao, int duracao, String categoria, Date dataPublicacao) {
		this.titulo = titulo;
		this.descricao = descricao;
		this.duracao = duracao;
		this.categoria = categoria;
		this.dataPublicacao = dataPublicacao;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public int getDuracao() {
		return duracao;
	}

	public String getCategoria() {
		return categoria;
	}

	public Date getDataPublicacao() {
		return dataPublicacao;
	}

	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String separator = "------------------------------";
		String message = "\n" + "Título: " + titulo + ";\n" + "Descrição: " + descricao + ";\n" + "Duração: " + duracao + ";\n" + "Categoria: " + categoria + ";\n" + "Data: " +
				                 sdf.format(dataPublicacao) + "\n";
		return separator + message + separator;
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