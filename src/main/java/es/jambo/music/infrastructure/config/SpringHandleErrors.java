package es.jambo.music.infrastructure.config;

import es.jambo.music.application.shared.error.ApplicationException;
import es.jambo.music.application.shared.error.ApplicationNotFoundException;
import es.jambo.music.domain.shared.error.DomainException;
import es.jambo.music.shared.message.MessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class SpringHandleErrors extends ResponseEntityExceptionHandler {

    private static final String PATTERN = "[%s] [%s]";
    private static final Logger LOGGER = LoggerFactory.getLogger(SpringHandleErrors.class);

    private final MessageService messageService;

    SpringHandleErrors(MessageService messageService) {
        this.messageService = messageService;
    }

    @ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY)
    @ExceptionHandler(value = {DomainException.class, ApplicationException.class})
    protected ResponseEntity<Object> handleDomainAccessError(RuntimeException ex, WebRequest request) {
        final var messageError = messageService.getMessage(ex.getMessage());
        LOGGER.error(String.format(PATTERN, ex.getMessage(), messageError), ex);
        return handleExceptionInternal(ex, messageService.getMessage(ex.getMessage()), new HttpHeaders(), HttpStatus.UNPROCESSABLE_ENTITY, request);
    }

    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ExceptionHandler(value = {ApplicationNotFoundException.class})
    protected ResponseEntity<Object> handleNotFoundError(RuntimeException ex, WebRequest request) {
        final var messageError = messageService.getMessage(ex.getMessage());
        LOGGER.error(String.format(PATTERN, ex.getMessage(), messageError), ex);
        return handleExceptionInternal(ex, messageError, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

}
