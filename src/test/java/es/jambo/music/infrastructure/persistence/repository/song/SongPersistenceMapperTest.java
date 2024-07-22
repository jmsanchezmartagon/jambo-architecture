package es.jambo.music.infrastructure.persistence.repository.song;

import es.jambo.music.utils.song.SongUtils;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class SongPersistenceMapperTest {

    @Test
    void should_getPersistenceSong_when_parseDomain() {
        final var song = SongUtils.createEntity();

        final var po = SongPersistenceMapper.FROM.domain(song);

        Assertions.assertThat(po.getId()).isEqualTo(song.id().value());
        Assertions.assertThat(po.getName()).isEqualTo(song.name().value());
        Assertions.assertThat(po.getDuration()).isEqualTo(song.duration().seconds());
        Assertions.assertThat(po.getCreatedAt()).isNull();
    }
}