package es.jambo.music.application.song.create;

import es.jambo.music.domain.shared.UuId;
import es.jambo.music.domain.song.entity.Song;
import es.jambo.music.domain.song.entity.SongDuration;
import es.jambo.music.domain.song.entity.SongName;

enum SongMapper {
    FROM;

    public Song dto(CreateSongDTO dto) {
        return new Song.Builder()
                .id(new UuId(dto.getId()))
                .name(new SongName(dto.getName()))
                .duration(new SongDuration(dto.getDuration())).build();
    }
}
