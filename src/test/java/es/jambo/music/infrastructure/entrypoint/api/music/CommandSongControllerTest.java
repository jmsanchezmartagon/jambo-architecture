package es.jambo.music.infrastructure.entrypoint.api.music;

import es.jambo.music.AbstractIntegrationTest;
import es.jambo.music.utils.song.SongUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;


final class CommandSongControllerTest extends AbstractIntegrationTest {

    @Autowired
    private CommandSongController commandSongController;

    @Test
    void should_notGiveError_when_createSong(){
        final var song = SongUtils.createDTO();
        commandSongController.create(song);

    }
}