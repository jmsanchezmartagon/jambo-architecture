package es.jambo.music.application.song.find;

import es.jambo.music.domain.shared.UuId;

import java.util.Optional;

public interface GetSongProjection {
    Optional<ViewSongDTO> byId(UuId id);
}
