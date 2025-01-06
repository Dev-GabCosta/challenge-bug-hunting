package model;

import service.ValidationService;

import javax.xml.crypto.Data;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.Date;

public class Video {
	private String titulo;
	private String descricao;
	private int duracao; // em minutos
	private String categoria;
	private String dataPublicacao;

	public Video(String titulo, String descricao, int duracao, String categoria, String dataPublicacao) {
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

	public String getDataPublicacao() {
		return dataPublicacao;
	}

	@Override
	public String toString() {
		return titulo + ";" + descricao + ";" + duracao + ";" + categoria + ";" + dataPublicacao;
	}

	public static Video fromString(String linha) {
		try {
			String[] partes = linha.split(";");

				return new Video(partes[0], partes[1], Integer.parseInt(partes[2]), partes[3], partes[4]);
		} catch (DateTimeParseException e) {
			System.out.println("Ocorreu um erro! " + e.getMessage());
			return null;
		}
	}
}