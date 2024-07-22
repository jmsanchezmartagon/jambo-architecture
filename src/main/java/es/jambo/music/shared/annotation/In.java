package es.jambo.music.shared.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

@Target({ElementType.CONSTRUCTOR, ElementType.METHOD, ElementType.PARAMETER, ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Autowired
public @interface In {
    @AliasFor(
            annotation = Autowired.class
    )
    boolean required() default true;
}



