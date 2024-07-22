package es.jambo.music.infrastructure.persistence.repository.song;

import es.jambo.music.infrastructure.persistence.dao.song.SongDAO;
import es.jambo.music.infrastructure.persistence.model.song.SongPO;
import es.jambo.music.utils.song.SongUtils;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
final class CreateSongRepositoryImplTest {

    @InjectMocks
    private CreateSongRepositoryImpl createSongRepository;
    @Mock
    private SongDAO songDAO;

    @Test
    void should_persistSong() {
        final var song = SongUtils.createEntity();

        createSongRepository.create(song);

        final var songCapture = ArgumentCaptor.forClass(SongPO.class);
        BDDMockito.verify(songDAO).create(songCapture.capture());
        final var songPO = songCapture.getValue();
        Assertions.assertThat(songPO).isNotNull();
        Assertions.assertThat(songPO.getId()).isEqualTo(song.id().value());
    }
}