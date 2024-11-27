package es.dws.gestion_videoclip.service;

import java.util.Set;

import es.dws.gestion_videoclip.model.Video;

public interface VideoService {

    Set<Video> getAllVideos();

    Video addVideo(final Video video);

    boolean deleteVideoById(final Integer id);

}
