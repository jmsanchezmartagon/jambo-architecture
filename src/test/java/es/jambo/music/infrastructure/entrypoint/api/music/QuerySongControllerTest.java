package es.jambo.music.infrastructure.entrypoint.api.music;

import es.jambo.music.AbstractIntegrationTest;
import es.jambo.music.utils.song.SongDaoUtils;
import es.jambo.music.utils.song.SongEntitiesUtils;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class QuerySongControllerTest extends AbstractIntegrationTest {
    @Autowired
    private QuerySongController querySongController;
    @Autowired
    private SongDaoUtils songDaoUtils;

    @Test
    void should_getViewSong_when_queryById() {
        final var po = SongEntitiesUtils.createPO();
        songDaoUtils.createdSong(po);

        final var entity = querySongController.get(po.getId());

        Assertions.assertThat(entity).isNotNull();
        Assertions.assertThat(entity.getId()).isEqualTo(po.getId());

        songDaoUtils.cleanCreatedSong(entity.getId());
    }

}