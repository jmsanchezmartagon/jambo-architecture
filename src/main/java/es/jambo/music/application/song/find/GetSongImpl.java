package es.jambo.music.application.song.find;

import es.jambo.music.application.shared.error.ApplicationNotFoundException;
import es.jambo.music.domain.shared.UuId;
import es.jambo.music.shared.annotation.ServiceComponent;

@ServiceComponent
final class GetSongImpl implements GetSong {

    private final GetSongProjection getSongProjection;

    GetSongImpl(GetSongProjection getSongProjection) {
        this.getSongProjection = getSongProjection;
    }

    @Override
    public ViewSongDTO byId(String id) {
        final var song = getSongProjection.byId(new UuId(id));
        return song.orElseThrow(ApplicationNotFoundException::new);
    }
}
