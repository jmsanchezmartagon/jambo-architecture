package es.jambo.music.infrastructure.persistence.model.song;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public final class SongPO {
    private String id;
    private String name;
    private Integer duration;
    private LocalDateTime createdAt;
}
