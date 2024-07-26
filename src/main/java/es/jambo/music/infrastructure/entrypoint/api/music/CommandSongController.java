package es.jambo.music.infrastructure.entrypoint.api.music;

import es.jambo.music.application.song.create.CreateSong;
import es.jambo.music.application.song.create.CreateSongDTO;
import es.jambo.music.infrastructure.shared.EndPoints;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(EndPoints.SongEndPoints.SONG)
final class CommandSongController {

    private final CreateSong createSong;

    public CommandSongController(CreateSong createSong) {
        this.createSong = createSong;
    }

    @PostMapping("/")
    public void create(@RequestBody CreateSongDTO song) {
        createSong.create(song);
    }
}
