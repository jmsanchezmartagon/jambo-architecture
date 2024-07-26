package es.jambo.music.domain.song.projection;

import es.jambo.music.application.song.find.GetSongProjection;
import es.jambo.music.application.song.find.ViewSongDTO;
import es.jambo.music.domain.shared.UuId;
import es.jambo.music.infrastructure.persistence.dao.song.SongDAO;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
final class GetSongProjectionImpl implements GetSongProjection {

    private final SongDAO songDAO;

    GetSongProjectionImpl(SongDAO songDAO) {
        this.songDAO = songDAO;
    }

    @Override
    public Optional<ViewSongDTO> byId(UuId id) {
        final var entity = songDAO.findById(id.value());
        if (entity != null)
            return Optional.of(ViewSongMapper.FROM.po(entity));
        return Optional.empty();
    }
}
