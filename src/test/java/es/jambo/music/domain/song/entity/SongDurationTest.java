package es.jambo.music.domain.song.entity;

import es.jambo.music.domain.shared.error.DomainException;
import es.jambo.music.shared.message.KeyMessageSource;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

final class SongDurationTest {

    @Test
    void should_getError_when_duration_is_zero() {
        final var expectedThrow = Assertions.catchThrowable(() -> new SongDuration(0));

        Assertions.assertThat(expectedThrow).isInstanceOf(DomainException.class)
                .hasMessage(KeyMessageSource.DOMAIN_SONG_DURATION_INVALID);
    }


    @Test
    void should_getSeconds_when_durationSongIsMayorThanOne() {
        final var songDuration = new SongDuration(1);
        Assertions.assertThat(songDuration.seconds()).isEqualTo(1);
    }

}