package es.jambo.music.domain.shared;

import es.jambo.music.domain.shared.error.DomainException;
import es.jambo.music.shared.message.KeyMessageSource;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.UUID;

class UuIdTest {

    @Test
    void should_getEntity_when_valueIsUUID() {
        var uuid = UUID.randomUUID().toString();

        final var entity = new UuId(uuid);

        Assertions.assertThat(entity).isNotNull();
        Assertions.assertThat(entity.value()).isEqualTo(uuid);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "  "})
    void should_fail_when_valueIsBlank(String value) {
        Throwable expectedThrow = Assertions.catchThrowable(() -> new UuId(value));

        Assertions.assertThat(expectedThrow).isInstanceOf(DomainException.class)
                .hasMessage(KeyMessageSource.DOMAIN_SHARED_UUID_INVALID_VALUE);

    }


    @Test
    void should_fail_when_valueIsNull() {
        Throwable expectedThrow = Assertions.catchThrowable(() -> new UuId(null));

        Assertions.assertThat(expectedThrow).isInstanceOf(DomainException.class)
                .hasMessage(KeyMessageSource.DOMAIN_SHARED_UUID_INVALID_VALUE);

    }
}