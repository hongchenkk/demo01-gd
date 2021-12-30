package com.godink.demo01.importSelector;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import org.springframework.context.annotation.Import;

@Import({AspectSelector.class})
@Retention(RUNTIME)
@Target({ TYPE, METHOD })
public @interface EnableAspect {

}
