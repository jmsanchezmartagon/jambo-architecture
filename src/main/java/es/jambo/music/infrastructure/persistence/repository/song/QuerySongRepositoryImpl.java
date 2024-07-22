package es.jambo.music.infrastructure.persistence.repository.song;

import es.jambo.music.domain.shared.UuId;
import es.jambo.music.domain.song.repository.QuerySongRepository;
import org.springframework.stereotype.Component;

@Component
final class QuerySongRepositoryImpl implements QuerySongRepository {
    @Override
    public boolean exists(UuId id) {
        return false;
    }
}
