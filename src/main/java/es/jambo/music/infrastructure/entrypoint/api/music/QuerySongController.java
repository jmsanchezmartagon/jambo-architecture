package es.jambo.music.infrastructure.entrypoint.api.music;

import es.jambo.music.application.song.find.GetSong;
import es.jambo.music.application.song.find.ViewSongDTO;
import es.jambo.music.infrastructure.shared.EndPoints;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(EndPoints.SongEndPoints.SONG)
final class QuerySongController {

    private final GetSong getSong;

    QuerySongController(GetSong getSong) {
        this.getSong = getSong;
    }

    @GetMapping("/{id}")
    public ViewSongDTO get(@PathVariable String id) {
        return getSong.byId(id);
    }
}
