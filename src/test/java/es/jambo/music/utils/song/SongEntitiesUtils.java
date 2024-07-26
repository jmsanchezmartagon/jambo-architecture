package es.jambo.music.utils.song;

import es.jambo.music.application.song.create.CreateSongDTO;
import es.jambo.music.domain.shared.UuId;
import es.jambo.music.domain.song.entity.Song;
import es.jambo.music.domain.song.entity.SongDuration;
import es.jambo.music.domain.song.entity.SongName;
import es.jambo.music.infrastructure.persistence.model.song.SongPO;
import es.jambo.music.utils.generator.StringGenerator;

import java.time.LocalDateTime;
import java.util.UUID;

public final class SongEntitiesUtils {

    public static final String SONG_ID = UUID.randomUUID().toString();
    public static final String SONG_NAME = "Runnin' Wild";
    public static final int SONG_DURATION = 222;

    public static CreateSongDTO createDTO() {
        final var dto = new CreateSongDTO();
        dto.setId(SONG_ID);
        dto.setName(SONG_NAME);
        dto.setDuration(SONG_DURATION);
        return dto;
    }

    public static Song createEntity() {
        return new Song.Builder()
                .id(new UuId(SONG_ID))
                .name(new SongName(SONG_NAME))
                .duration(new SongDuration(SONG_DURATION)).build();
    }

    public static Song.Builder createBuilder() {
        return new Song.Builder()
                .id(new UuId(SONG_ID))
                .name(new SongName(SONG_NAME))
                .duration(new SongDuration(SONG_DURATION));
    }

    public static SongPO createPO() {
        final var po = new SongPO();
        po.setId(UUID.randomUUID().toString());
        po.setName(StringGenerator.getRandomFrom(20));
        po.setDuration(243);
        po.setCreatedAt(LocalDateTime.now());
        return po;
    }
}
