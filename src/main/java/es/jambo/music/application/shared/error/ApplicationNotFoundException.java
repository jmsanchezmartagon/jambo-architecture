package es.jambo.music.application.shared.error;

import es.jambo.music.shared.message.KeyMessageSource;

public class ApplicationNotFoundException extends ApplicationException {
    public ApplicationNotFoundException() {
        super(KeyMessageSource.DOMAIN_SHARED_RESOURCE_NOT_FOUND);
    }
}
