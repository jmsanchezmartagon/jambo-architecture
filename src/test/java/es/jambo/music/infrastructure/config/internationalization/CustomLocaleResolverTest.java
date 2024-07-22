package es.jambo.music.infrastructure.config.internationalization;

import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;

import java.util.Locale;

import static org.assertj.core.api.Assertions.assertThat;

class CustomLocaleResolverTest {

    private static final Locale LOCALE_DEFAULT = Locale.forLanguageTag("es-ES");

    private final CustomLocaleResolver customLocaleResolver = new CustomLocaleResolver();

    @Test
    void should_returnLocaleDefault_when_notAcceptLanguage() {
        MockHttpServletRequest request = new MockHttpServletRequest();
        assertThat(customLocaleResolver.resolveLocale(request)).isEqualTo(LOCALE_DEFAULT);
    }

    @Test
    void should_beMessageForLanguageDefault() {
        MockHttpServletRequest request = new MockHttpServletRequest();
        final var locale = customLocaleResolver.resolveLocale(request);
        final var messagesSource = customLocaleResolver.messageSource();
        final var result = messagesSource.getMessage("es.jambo.music.shared.domain.shared.id.is_required", null, locale);
        assertThat(result).isEqualTo("El Id es obligatorio");
    }

}