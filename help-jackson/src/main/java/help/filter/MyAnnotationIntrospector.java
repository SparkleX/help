package help.filter;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.introspect.Annotated;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;

public class MyAnnotationIntrospector extends AnnotationIntrospector 
{
	@Override
	public Version version() 
	{
		return null;
	}
	@Override
	public boolean hasIgnoreMarker(AnnotatedMember m) 
	{
		  IgnoreLevel lvl = m.getAnnotation(IgnoreLevel.class);
		  if(lvl!=null)
		  {
			  if (lvl.value().equals("1")) return true;
		  }
		  return super.hasIgnoreMarker(m);
	}

}
