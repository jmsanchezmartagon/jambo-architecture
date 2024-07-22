package es.jambo.music.application.song.create;

import lombok.Data;

@Data
public class SongDTO {
    private String id;
    private String name;
    private Integer duration;
}
