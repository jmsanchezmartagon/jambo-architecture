package es.jambo.music.application.song.create;

import es.jambo.music.utils.song.SongEntitiesUtils;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class SongMapperTest {
    @Test
    void should_getASong_when_mapSongInformation() {
        final var dto = SongEntitiesUtils.createDTO();

        final var song = SongMapper.FROM.dto(dto);

        Assertions.assertThat(song).isNotNull();
        Assertions.assertThat(song.id().value()).isEqualTo(SongEntitiesUtils.SONG_ID);
        Assertions.assertThat(song.name().value()).isEqualTo(SongEntitiesUtils.SONG_NAME);
        Assertions.assertThat(song.duration().seconds()).isEqualTo(SongEntitiesUtils.SONG_DURATION);
    }
}