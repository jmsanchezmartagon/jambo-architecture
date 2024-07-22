package es.jambo.music.application.song.create;

import es.jambo.music.utils.song.SongUtils;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class SongMapperTest {
    @Test
    void should_getASong_when_mapSongInformation() {
        final var dto = SongUtils.createDTO();

        final var song = SongMapper.from.dto(dto);

        Assertions.assertThat(song).isNotNull();
        Assertions.assertThat(song.id().value()).isEqualTo(SongUtils.SONG_ID);
        Assertions.assertThat(song.name().value()).isEqualTo(SongUtils.SONG_NAME);
        Assertions.assertThat(song.duration().seconds()).isEqualTo(SongUtils.SONG_DURATION);
    }
}