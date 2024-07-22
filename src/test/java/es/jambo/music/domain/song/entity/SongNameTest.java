package es.jambo.music.domain.song.entity;

import es.jambo.music.domain.shared.error.DomainException;
import es.jambo.music.shared.message.KeyMessageSource;
import es.jambo.music.utils.generator.StringGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

final class SongNameTest {

    @Test
    void should_getSongName_when_nameIsCorrect() {
        final var name = "The troopers";
        final var songName = new SongName(name);
        Assertions.assertThat(songName.value()).isEqualTo(name);
    }

    @Test
    void should_getError_when_nameIsEmpty() {
        final var error = Assertions.catchException(() -> new SongName(""));
        Assertions.assertThat(error).isInstanceOf(DomainException.class).hasMessage(KeyMessageSource.DOMAIN_SONG_NAME_IS_BLANK);
    }

    @Test
    void should_getError_when_nameIsNull() {
        final var error = Assertions.catchException(() -> new SongName(null));
        Assertions.assertThat(error).isInstanceOf(DomainException.class).hasMessage(KeyMessageSource.DOMAIN_SONG_NAME_IS_BLANK);
    }

    @Test
    void should_getError_when_nameIsNotValid() {
        final var error = Assertions.catchThrowable(() -> new SongName("245#25"));
        Assertions.assertThat(error).isInstanceOf(DomainException.class).hasMessage(KeyMessageSource.DOMAIN_SONG_NAME_IS_INVALID);
    }

    @Test
    void should_getError_when_nameLengthIsExceeded() {
        final var error = Assertions.catchThrowable(() -> new SongName(StringGenerator.getRandomFrom(101)));
        Assertions.assertThat(error).isInstanceOf(DomainException.class).hasMessage(KeyMessageSource.DOMAIN_SONG_NAME_LENGTH_OVERFLOW);
    }

}