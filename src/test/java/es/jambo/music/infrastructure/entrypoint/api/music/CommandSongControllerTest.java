package es.jambo.music.infrastructure.entrypoint.api.music;

import es.jambo.music.AbstractIntegrationTest;
import es.jambo.music.utils.song.SongDaoUtils;
import es.jambo.music.utils.song.SongEntitiesUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;


final class CommandSongControllerTest extends AbstractIntegrationTest {

    @Autowired
    private CommandSongController commandSongController;

    @Autowired
    private SongDaoUtils songDaoUtils;

    @Test
    void should_notGiveError_when_createSong() {
        final var song = SongEntitiesUtils.createDTO();
        commandSongController.create(song);
        songDaoUtils.assertSongCreated(song.getId());
        songDaoUtils.cleanCreatedSong(song.getId());
    }
}