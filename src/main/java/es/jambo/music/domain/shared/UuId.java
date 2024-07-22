package es.jambo.music.domain.shared;

import es.jambo.music.domain.shared.error.DomainException;
import es.jambo.music.shared.message.KeyMessageSource;

import java.util.regex.Pattern;

public record UuId(String value) {

    private static final String UUID_REGEX = "^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}$";
    private static final Pattern UUID_PATTERN = Pattern.compile(UUID_REGEX);

    public UuId {
        if (value == null || !UUID_PATTERN.matcher(value).matches()) {
            throw new DomainException(KeyMessageSource.DOMAIN_SHARED_UUID_INVALID_VALUE);
        }
    }
}
