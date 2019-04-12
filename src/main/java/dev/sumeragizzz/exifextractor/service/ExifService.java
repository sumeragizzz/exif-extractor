package dev.sumeragizzz.exifextractor.service;

import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.drew.imaging.ImageMetadataReader;
import com.drew.imaging.ImageProcessingException;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.Tag;

public class ExifService {

	public ExifService() {
		// NOP
	}

	public void extract(InputStream inputStream) {
		try {
			Metadata metadata = ImageMetadataReader.readMetadata(inputStream);
			for (Directory directory : metadata.getDirectories()) {
				for (Tag tag : directory.getTags()) {
					System.out.format("%s : %s%n", tag.getTagName(), tag.getDescription());
				}
			}
		} catch (ImageProcessingException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new UncheckedIOException(e);
		}
	}

	public static void main(String[] args) {
		Path path = Paths.get("G:/Development/icon/ball-toss.jpg");

		ExifService service = new ExifService();
		try (InputStream inputStream = Files.newInputStream(path)) {
			service.extract(inputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
