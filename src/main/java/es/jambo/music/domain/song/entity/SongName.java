package es.jambo.music.domain.song.entity;

import es.jambo.music.domain.shared.error.DomainException;
import es.jambo.music.shared.message.KeyMessageSource;

import java.util.regex.Pattern;

public record SongName(String value) {

    private static final int MAX_SIZE = 100;
    private static final String SONG_NAME_REGEX = "^[\\w\\s\\.,'\"\\(\\)\\-\\[\\]!&\\+\\?]*$";
    private static final Pattern SONG_NAME_PATTERN = Pattern.compile(SONG_NAME_REGEX);

    public SongName {
        if (value == null || value.isBlank()) {
            throw new DomainException(KeyMessageSource.DOMAIN_SONG_NAME_IS_BLANK);
        }
        if (!SONG_NAME_PATTERN.matcher(value).matches()) {
            throw new DomainException(KeyMessageSource.DOMAIN_SONG_NAME_IS_INVALID);
        }
        if (value.length() > MAX_SIZE) {
            throw new DomainException(KeyMessageSource.DOMAIN_SONG_NAME_LENGTH_OVERFLOW);
        }
    }

}
