package es.dws.gestion_videoclip.service;

import java.time.Year;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

import es.dws.gestion_videoclip.enumeration.GenreEnum;
import es.dws.gestion_videoclip.model.Video;

@Service
public class VideoServiceImpl implements VideoService {

    private static final Set<Video> videos = new LinkedHashSet<Video>();

    private static int counter = 0;

    @Override
    public Set<Video> getAllVideos() {

        if (videos.isEmpty()) {
            // agrega videos random
            final Random random = new Random();

            videos.addAll(Stream.generate(() -> Video.builder()
                    .id(counter++)
                    .title("Video " + random.nextInt(1000))
                    .artist("Artist " + random.nextInt(100))
                    .genre(GenreEnum.values()[random.nextInt(GenreEnum.values().length)])
                    .releaseYear(random.nextBoolean() ? Year.of(random.nextInt(120) + 1900) : null)
                    .videoUrl("https://example.com/video" + random.nextInt(1000))
                    .build())
                    .limit(5)
                    .collect(Collectors.toSet()));

            videos.add(Video.builder()
                    .id(counter++)
                    .title("Best video ever")
                    .artist("Secret")
                    .genre(GenreEnum.POP)
                    .releaseYear(null)
                    .videoUrl("https://www.youtube.com/embed/dQw4w9WgXcQ")
                    .build());
        }

        return videos;
    }

    @Override
    public Video addVideo(Video video) {
        if (!videos.add(video)) {
            throw new RuntimeException("No se pudo agregar el video");
        }
        video.setId(counter++);
        return video;
    }

    @Override
    public boolean deleteVideoById(Integer id) {
        return videos.removeIf(video -> video.getId() == id);
    }

}
