package es.jambo.music.application.song.create;

import es.jambo.music.application.shared.error.ApplicationException;
import es.jambo.music.domain.shared.UuId;
import es.jambo.music.domain.song.entity.Song;
import es.jambo.music.domain.song.repository.CreateSongRepository;
import es.jambo.music.domain.song.repository.QuerySongRepository;
import es.jambo.music.shared.message.KeyMessageSource;
import es.jambo.music.utils.song.SongEntitiesUtils;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CreateSongImplTest {

    @InjectMocks
    private CreateSongImpl createSong;
    @Mock
    private CreateSongRepository createSongRepository;
    @Mock
    private QuerySongRepository querySongRepository;

    @Test
    void should_createSong_when_haveSongData() {
        final var data = SongEntitiesUtils.createDTO();
        createSong.create(data);

        final var songCapture = ArgumentCaptor.forClass(Song.class);
        BDDMockito.verify(createSongRepository).create(songCapture.capture());
        final var song = songCapture.getValue();
        Assertions.assertThat(song).isNotNull();
        Assertions.assertThat(song.id().value()).isEqualTo(data.getId());

        BDDMockito.verify(querySongRepository).exists(new UuId(data.getId()));
    }

    @Test
    void should_getError_when_createSongThatExists() {
        final var data = SongEntitiesUtils.createDTO();
        BDDMockito.given(querySongRepository.exists(new UuId(data.getId()))).willReturn(Boolean.TRUE);

        final var error = Assertions.catchThrowable(() -> createSong.create(data));
        Assertions.assertThat(error).isInstanceOf(ApplicationException.class).hasMessage(KeyMessageSource.APPLICATION_SONG_EXISTS);
    }
}