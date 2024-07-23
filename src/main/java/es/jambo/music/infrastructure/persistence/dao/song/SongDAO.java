package es.jambo.music.infrastructure.persistence.dao.song;

import es.jambo.music.infrastructure.persistence.model.song.SongPO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SongDAO {

    int create(SongPO entity);

    SongPO findById(String id);
}
