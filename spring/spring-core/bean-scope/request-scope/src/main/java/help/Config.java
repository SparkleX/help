package help;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.SimpleThreadScope;

@Configuration
public class Config 
{
	@Bean
	public static BeanFactoryPostProcessor beanFactoryPostProcessor() 
	{
	    return new BeanFactoryPostProcessor() {
	        @Override
	        public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException 
	        {
	            beanFactory.registerScope("thread", new SimpleThreadScope());
	        }
	    };
	}
}
