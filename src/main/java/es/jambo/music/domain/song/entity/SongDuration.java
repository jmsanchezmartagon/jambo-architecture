package es.jambo.music.domain.song.entity;

import es.jambo.music.domain.shared.error.DomainException;
import es.jambo.music.shared.message.KeyMessageSource;

public record SongDuration(int seconds) {

    public SongDuration {
        if (seconds < 1) {
            throw new DomainException(KeyMessageSource.DOMAIN_SONG_DURATION_INVALID);
        }
    }

}
