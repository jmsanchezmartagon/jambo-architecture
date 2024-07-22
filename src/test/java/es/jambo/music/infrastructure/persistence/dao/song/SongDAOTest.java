package es.jambo.music.infrastructure.persistence.dao.song;

import es.jambo.music.AbstractIntegrationTest;
import es.jambo.music.infrastructure.persistence.model.song.SongPO;
import es.jambo.music.utils.song.SongUtils;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Juan Manuel Sánchez Martagón <jmsanchezmartagon@gmail.com>
 */
final class SongDAOTest extends AbstractIntegrationTest {

    @Autowired
    private SongDAO dao;

    @Autowired
    private SongDaoTestUtils utils;

    @Test
    void should_getAll_when_readRecordsWithoutOffset() {
        final var po = SongUtils.createPO();

        dao.create(po);

        utils.assertSongCreated(po.getId());
        utils.cleanCreatedSong(po.getId());
    }

    @Test
    void should_getSong_when_searchById() {
        final var po = SongUtils.createPO();
        utils.createdSong(po);

        final var song = dao.findById(po.getId());
        assertFoundSong(song, po);

        utils.cleanCreatedSong(po.getId());
    }

    private void assertFoundSong(SongPO song, SongPO po) {
        Assertions.assertThat(song).isNotNull();
        Assertions.assertThat(song.getId()).isEqualTo(po.getId());
        Assertions.assertThat(song.getName()).isEqualTo(po.getName());
        Assertions.assertThat(song.getDuration()).isEqualTo(po.getDuration());
        Assertions.assertThat(song.getCreatedAt()).isEqualToIgnoringNanos(po.getCreatedAt());
    }
}
