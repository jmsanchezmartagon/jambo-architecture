package es.jambo.music.application.song.find;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public final class ViewSongDTO {
    private String id;
    private String name;
    private int duration;
    private LocalDateTime createAt;
}
