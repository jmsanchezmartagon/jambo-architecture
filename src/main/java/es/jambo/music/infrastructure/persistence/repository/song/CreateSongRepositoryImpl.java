package es.jambo.music.infrastructure.persistence.repository.song;

import es.jambo.music.domain.song.entity.Song;
import es.jambo.music.domain.song.repository.CreateSongRepository;
import es.jambo.music.infrastructure.persistence.dao.song.SongDAO;
import org.springframework.stereotype.Component;

@Component
final class CreateSongRepositoryImpl implements CreateSongRepository {

    private final SongDAO songDAO;

    public CreateSongRepositoryImpl(SongDAO songDAO) {
        this.songDAO = songDAO;
    }

    @Override
    public void create(Song song) {
        songDAO.create(SongPersistenceMapper.FROM.domain(song));
    }
}
