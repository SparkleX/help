package spring.i18n.properties;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

@Component
public class MessageUtil {
    @Autowired
    private MessageSource messageSource;

	public String getMessage(String code) {
		Locale locale = LocaleContextHolder.getLocale();
		String rt = messageSource.getMessage(code, null, locale);
		return rt;
	}
}
