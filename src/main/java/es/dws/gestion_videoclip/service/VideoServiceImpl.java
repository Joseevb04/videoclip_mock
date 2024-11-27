package es.dws.gestion_videoclip.service;

import java.time.Year;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

import es.dws.gestion_videoclip.model.Video;

@Service
public class VideoServiceImpl implements VideoService {

    private static final Set<Video> videos = new LinkedHashSet<Video>();

    private static int counter = 0;

    @Override
    public Set<Video> getAllVideos() {
        {
            // agrega videos random
            final Random random = new Random();

            videos.addAll(Stream.generate(() -> Video.builder()
                    .id(random.nextInt(1000))
                    .title("Video " + random.nextInt(1000))
                    .artist("Artist " + random.nextInt(100))
                    .genre("Genre " + random.nextInt(10))
                    .releaseYear(random.nextBoolean() ? Year.of(random.nextInt(120) + 1900) : null)
                    .videoUrl("https://example.com/video" + random.nextInt(1000))
                    .build())
                    .limit(5)
                    .collect(Collectors.toSet()));
        }

        videos.forEach(System.out::println);

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
