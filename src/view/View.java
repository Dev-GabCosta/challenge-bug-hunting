package view;

import model.Video;
import service.VideoService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class View {
	private final Scanner INPUT = new Scanner(System.in);
	private final static VideoService VIDEOSERVICE;

	public static void displayMenu() {
		String menu = """
				=== Sistema de Gerenciamento de Vídeos ===
					Escolha uma opção:
						1. Listar vídeos
						2. Adicionar vídeo
						3. Pesquisar vídeo por título
						4. Sair
				""";

		System.out.println(menu);
	}

	public static void addVideo() {
		System.out.print("Digite o título do vídeo: ");
		String titulo = scanner.nextLine();
		System.out.print("Digite a descrição do vídeo: ");
		String descricao = scanner.nextLine();
		System.out.print("Digite a duração do vídeo (em minutos): ");
		int duracao = scanner.nextInt();
		scanner.nextLine(); // Consumir a quebra de linha
		System.out.print("Digite a categoria do vídeo: ");
		String categoria = scanner.nextLine();
		System.out.print("Digite a data de publicação (dd/MM/yyyy): ");
		String dataStr = scanner.nextLine();

		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Date dataPublicacao = sdf.parse(dataStr);
			Video video = new Video(titulo, descricao, duracao, categoria, dataPublicacao);
			videoService.addVideo(video);
			System.out.println("Vídeo adicionado com sucesso!");
		} catch (Exception e) {
			System.out.println("Erro ao adicionar vídeo.");
		}

	}

	public static void listVideos() {
		List<Video> videos = VIDEOSERVICE.listVideos();

		for (Video video : videos) {
			System.out.println(video);
		}

	}

	public static void searchVideoByTitle() {

		System.out.print("Digite o título para busca: ");
		String query = scanner.nextLine();
		List<Video> resultados = searchStrategy.search(videoService.listVideos(), query);
		for (
				Video video : resultados) {
			System.out.println(video);
		}

	}


}
