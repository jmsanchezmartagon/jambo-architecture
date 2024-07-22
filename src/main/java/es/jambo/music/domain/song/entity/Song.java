package es.jambo.music.domain.song.entity;

import es.jambo.music.domain.shared.UuId;
import es.jambo.music.domain.shared.error.DomainException;
import es.jambo.music.shared.message.KeyMessageSource;

import java.util.Objects;

public final class Song {
    private final UuId id;
    private final SongName name;
    private final SongDuration duration;

    public static final class Builder {
        private UuId id;
        private SongName name;
        private SongDuration duration;

        public Builder id(UuId id) {
            this.id = id;
            return this;
        }

        public Builder name(SongName name) {
            this.name = name;
            return this;
        }

        public Builder duration(SongDuration duration) {
            this.duration = duration;
            return this;
        }

        public Song build() {

            if (id == null) {
                throw new DomainException(KeyMessageSource.DOMAIN_SHARED_ID_IS_REQUIRED);
            }

            if (name == null) {
                throw new DomainException(KeyMessageSource.DOMAIN_SONG_NAME_IS_REQUIRED);
            }

            if (duration == null) {
                throw new DomainException(KeyMessageSource.DOMAIN_SONG_DURATION_IS_REQUIRED);
            }
            return new Song(this);
        }
    }

    private Song(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.duration = builder.duration;
    }

    public UuId id() {
        return id;
    }

    public SongName name() {
        return name;
    }

    public SongDuration duration() {
        return duration;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Song song = (Song) o;
        return Objects.equals(id, song.id) && Objects.equals(name, song.name) && Objects.equals(duration, song.duration);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, duration);
    }

    @Override
    public String toString() {
        return "Song{" +
                "id=" + id +
                ", name=" + name +
                ", duration=" + duration +
                '}';
    }
}
