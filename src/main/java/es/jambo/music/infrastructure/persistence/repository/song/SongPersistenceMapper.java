package es.jambo.music.infrastructure.persistence.repository.song;

import es.jambo.music.domain.song.entity.Song;
import es.jambo.music.infrastructure.persistence.model.song.SongPO;

enum SongPersistenceMapper {
    FROM;

    public SongPO domain(Song song) {
        final var po = new SongPO();
        po.setId(song.id().value());
        po.setName(song.name().value());
        po.setDuration(song.duration().seconds());
        return po;
    }
}
