package es.jambo.music.domain.song.entity;

import es.jambo.music.domain.shared.error.DomainException;
import es.jambo.music.shared.message.KeyMessageSource;
import es.jambo.music.utils.song.SongEntitiesUtils;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

final class SongTest {

    @Test
    void should_getError_when_songHasNotId() {
        final var songBuilder = SongEntitiesUtils.createBuilder().id(null);

        final var error = Assertions.catchThrowable(songBuilder::build);

        Assertions.assertThat(error).isInstanceOf(DomainException.class).hasMessage(KeyMessageSource.DOMAIN_SHARED_ID_IS_REQUIRED);
    }

    @Test
    void should_getError_when_songHasNotName() {
        final var songBuilder = SongEntitiesUtils.createBuilder().name(null);

        final var error = Assertions.catchThrowable(songBuilder::build);

        Assertions.assertThat(error).isInstanceOf(DomainException.class).hasMessage(KeyMessageSource.DOMAIN_SONG_NAME_IS_REQUIRED);
    }

    @Test
    void should_getError_when_songHasNotDuration() {
        final var songBuilder = SongEntitiesUtils.createBuilder().duration(null);

        final var error = Assertions.catchThrowable(songBuilder::build);

        Assertions.assertThat(error).isInstanceOf(DomainException.class).hasMessage(KeyMessageSource.DOMAIN_SONG_DURATION_IS_REQUIRED);
    }

    @Test
    void should_getEntity_when_buildSongData() {
        final var songBuilder = SongEntitiesUtils.createBuilder();

        final var song = songBuilder.build();
        Assertions.assertThat(song.id().value()).isEqualTo(SongEntitiesUtils.SONG_ID);
        Assertions.assertThat(song.name().value()).isEqualTo(SongEntitiesUtils.SONG_NAME);
        Assertions.assertThat(song.duration().seconds()).isEqualTo(SongEntitiesUtils.SONG_DURATION);
    }
}