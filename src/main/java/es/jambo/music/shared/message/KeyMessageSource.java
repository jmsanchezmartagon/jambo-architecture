package es.jambo.music.shared.message;

public final class KeyMessageSource {

    private KeyMessageSource() {
    }

    //DOMAIN
    public static final String DOMAIN_SHARED_ID_IS_REQUIRED = "es.jambo.music.shared.domain.shared.id.is_required";
    public static final String DOMAIN_SHARED_RESOURCE_NOT_FOUND = "es.jambo.music.shared.domain.shared.resource.not_found";
    public static final String DOMAIN_SHARED_UUID_INVALID_VALUE = "es.jambo.music.shared.domain.shared.uuid.invalid_value";
    public static final String DOMAIN_SONG_NAME_IS_BLANK = "es.jambo.music.domain.song.name.is_blank";
    public static final String DOMAIN_SONG_NAME_IS_INVALID = "es.jambo.music.domain.song.name.is_invalid";
    public static final String DOMAIN_SONG_NAME_LENGTH_OVERFLOW = "es.jambo.music.domain.song.name.length_overflow";
    public static final String DOMAIN_SONG_DURATION_INVALID = "es.jambo.music.domain.song.duration.invalid_length";
    public static final String DOMAIN_SONG_NAME_IS_REQUIRED = "es.jambo.music.domain.song.name.is_required";
    public static final String DOMAIN_SONG_DURATION_IS_REQUIRED = "es.jambo.music.domain.song.duration.is_required";

    // APPLICATION
    public static final String APPLICATION_SONG_EXISTS = "es.jambo.music.application.song.exists";
}
