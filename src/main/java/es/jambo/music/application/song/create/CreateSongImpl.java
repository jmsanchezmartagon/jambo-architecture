package es.jambo.music.application.song.create;

import es.jambo.music.application.shared.error.ApplicationException;
import es.jambo.music.domain.song.repository.CreateSongRepository;
import es.jambo.music.domain.song.repository.QuerySongRepository;
import es.jambo.music.shared.message.KeyMessageSource;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


@Component
@Transactional
class CreateSongImpl implements CreateSong {

    private final CreateSongRepository createSongRepository;
    private final QuerySongRepository querySongRepository;

    CreateSongImpl(CreateSongRepository createSongRepository, QuerySongRepository querySongRepository) {
        this.createSongRepository = createSongRepository;
        this.querySongRepository = querySongRepository;
    }

    @Override
    public void create(SongDTO songDTO) {
        final var song = SongMapper.from.dto(songDTO);

        final var exists = querySongRepository.exists(song.id());
        if (exists)
            throw new ApplicationException(KeyMessageSource.APPLICATION_SONG_EXISTS);

        createSongRepository.create(song);
    }
}
