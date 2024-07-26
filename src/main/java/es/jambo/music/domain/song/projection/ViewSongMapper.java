package es.jambo.music.domain.song.projection;

import es.jambo.music.application.song.find.ViewSongDTO;
import es.jambo.music.infrastructure.persistence.model.song.SongPO;

enum ViewSongMapper {
    FROM;

    public ViewSongDTO po(SongPO persistenceObject) {
        final var view = new ViewSongDTO();
        view.setId(persistenceObject.getId());
        view.setName(persistenceObject.getName());
        view.setDuration(persistenceObject.getDuration());
        view.setCreateAt(persistenceObject.getCreatedAt());
        return view;
    }
}
