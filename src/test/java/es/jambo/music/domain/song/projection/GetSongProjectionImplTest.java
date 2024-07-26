package es.jambo.music.domain.song.projection;

import es.jambo.music.domain.shared.UuId;
import es.jambo.music.infrastructure.persistence.dao.song.SongDAO;
import es.jambo.music.utils.song.SongEntitiesUtils;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

@ExtendWith(MockitoExtension.class)
class GetSongProjectionImplTest {

    @InjectMocks
    private GetSongProjectionImpl getSongProjection;
    @Mock
    private SongDAO songDAO;

    @Test
    void should_getView_when_entityExists() {
        final var po = SongEntitiesUtils.createPO();
        final var id = new UuId(po.getId());

        BDDMockito.given(songDAO.findById(id.value())).willReturn(po);

        final var view = getSongProjection.byId(id);
        Assertions.assertThat(view).isNotEmpty();
        Assertions.assertThat(view.get().getId()).isEqualTo(id.value());
    }

    @Test
    void should_beEmpty_when_entityNotExists() {
        final var id = new UuId(UUID.randomUUID().toString());

        BDDMockito.given(songDAO.findById(id.value())).willReturn(null);

        final var view = getSongProjection.byId(id);
        Assertions.assertThat(view).isNotNull().isEmpty();
    }
}