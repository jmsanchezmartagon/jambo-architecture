package es.jambo.music.domain.song.repository;

import es.jambo.music.domain.song.entity.Song;

public interface CreateSongRepository {
    void create(Song song);
}
