package es.jambo.music.domain.shared.error;

public final class DomainException extends RuntimeException {
    public DomainException(String message) {
        super(message);
    }
}