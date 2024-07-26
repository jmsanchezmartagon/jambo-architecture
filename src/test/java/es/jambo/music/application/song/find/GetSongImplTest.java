package es.jambo.music.application.song.find;

import es.jambo.music.application.shared.error.ApplicationNotFoundException;
import es.jambo.music.domain.shared.UuId;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.UUID;

@ExtendWith(MockitoExtension.class)
class GetSongImplTest {

    @InjectMocks
    private GetSongImpl getSong;
    @Mock
    private GetSongProjection getSongProjection;

    @Test
    void should_getView_when_idSongExists() {
        final var id = UUID.randomUUID().toString();
        final var existsSong = new ViewSongDTO();
        BDDMockito.given(getSongProjection.byId(new UuId(id))).willReturn(Optional.of(existsSong));

        final var view = getSong.byId(id);

        Assertions.assertThat(view).isEqualTo(existsSong);
    }

    @Test
    void should_getNotFound_when_songNotExists() {
        final var id = UUID.randomUUID().toString();
        BDDMockito.given(getSongProjection.byId(new UuId(id))).willReturn(Optional.empty());
        final var error = Assertions.catchThrowable(() -> getSong.byId(id));
        Assertions.assertThat(error).isInstanceOf(ApplicationNotFoundException.class);
    }
}