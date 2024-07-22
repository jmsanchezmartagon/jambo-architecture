package es.jambo.music.domain.song.repository;

import es.jambo.music.domain.shared.UuId;

public interface QuerySongRepository {
    boolean exists(UuId id);
}
