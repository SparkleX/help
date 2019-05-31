package help.spring.i18n.lib;

import java.util.Locale;

import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Component;

@Component
public class Library 
{
	public String getString()
	{
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasenames("i18n/msg2");
        messageSource.setBundleClassLoader(this.getClass().getClassLoader());
		Locale locale = LocaleContextHolder.getLocale();
		return messageSource.getMessage("msg2text",null, "(---)",locale);
	}
}
