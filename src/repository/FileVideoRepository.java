package repository;

import model.Video;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileVideoRepository implements VideoRepository {
	private final File file;

	public FileVideoRepository(String filePath) {
		this.file = new File(filePath);
	}

	@Override
	public void save(Video video) {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))) {
			bw.write(video.toString());
			bw.newLine();
		} catch (IOException e) {
			// Ignorar erros por enquanto
		}
	}

	@Override
	public List<Video> findAll() {
		List<Video> videos = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String line;
			while ((line = br.readLine()) != null) {
				Video video = Video.fromString(line);
				if (video != null) {
					videos.add(video);
				}
			}
		} catch (IOException e) {
			System.out.println("Opa! Algo indevido ocorreu por aqui: " + e.getMessage());
		}
		return videos;
	}

	@Override
	public void delete(String title) {
		List<Video> videos = findAll();

		videos.removeIf(video -> video.getTitulo().equalsIgnoreCase(title));

		try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {

			for (Video video : videos) {
				writer.write(video.toString());
				writer.newLine();
			}
		} catch (IOException exception) {
			System.out.println("Ocorreu uma falha ao tentar gravar no arquivo: " + exception.getMessage());
		}

	}

	@Override
	public void edit(Video video) {
		List<Video> videos = findAll();

		for (int i = 0; i < videos.size(); i ++){
			System.out.println(video.getTitulo());
			if (videos.get(i).getTitulo().equalsIgnoreCase(video.getTitulo())){
				videos.set(i, video);
				System.out.println("É igual!");
				break;
			}

		}

			try (BufferedWriter write = new BufferedWriter(new FileWriter(file))) {

				for (Video v : videos){
					write.write(v.toString());
					write.newLine();
				}

			} catch (IOException e) {
				System.out.println("Ocorreu erro ao tentar gravar no arquivo: " + e.getMessage());
			}

	}
}