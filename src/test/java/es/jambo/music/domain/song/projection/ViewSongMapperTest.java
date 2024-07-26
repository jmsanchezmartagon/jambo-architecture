package es.jambo.music.domain.song.projection;

import es.jambo.music.utils.song.SongEntitiesUtils;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class ViewSongMapperTest {

    @Test
    void should_getView_when_mapperPO() {
        final var entity = SongEntitiesUtils.createPO();
        final var view = ViewSongMapper.FROM.po(entity);
        Assertions.assertThat(view.getId()).isEqualTo(entity.getId());
        Assertions.assertThat(view.getName()).isEqualTo(entity.getName());
        Assertions.assertThat(view.getDuration()).isEqualTo(entity.getDuration());
        Assertions.assertThat(view.getCreateAt()).isEqualTo(entity.getCreatedAt());
    }

}