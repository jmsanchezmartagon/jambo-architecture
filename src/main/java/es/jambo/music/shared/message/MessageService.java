package es.jambo.music.shared.message;

import java.util.Optional;

public interface MessageService {
    String getMessage(String key);

    String getMessage(String key, Optional<String[]> values);
}
