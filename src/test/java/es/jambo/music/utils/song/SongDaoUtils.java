package es.jambo.music.utils.song;

import es.jambo.music.infrastructure.persistence.model.song.SongPO;
import org.assertj.core.api.Assertions;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public final class SongDaoUtils{

    private JdbcTemplate jdbcTemplate;

    public SongDaoUtils(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void assertSongCreated(String id) {
        final var savedRecord = jdbcTemplate.queryForObject("select count(1) from song where id = ?", Integer.class, id);
        Assertions.assertThat(savedRecord).isEqualTo(1);
    }

    public void cleanCreatedSong(String id) {
        jdbcTemplate.update("delete from song where id = ?", id);
    }

    public void createdSong(SongPO song) {
        jdbcTemplate.update("INSERT INTO SONG (ID,NAME,DURATION,CREATED_AT) VALUES (?,?,?,?)", song.getId(), song.getName(), song.getDuration(), song.getCreatedAt());
    }
}
