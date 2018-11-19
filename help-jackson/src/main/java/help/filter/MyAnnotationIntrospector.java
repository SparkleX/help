package help.filter;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.introspect.Annotated;

public class MyAnnotationIntrospector extends AnnotationIntrospector 
{
	private static final long serialVersionUID = -7361669659256367415L;

	@Override
	public Version version() 
	{
		return null;
	}

	 public JsonProperty.Access findPropertyAccess(Annotated ann) 
	 { 
		 IgnoreLevel lvl = ann.getAnnotation(IgnoreLevel.class);
		 if(lvl!=null)
		  {
			  if (lvl.value().equals("1")) return JsonProperty.Access.WRITE_ONLY;
		  }
		 return null; 
	 }
	/*@Override
	public boolean hasIgnoreMarker(AnnotatedMember m) 
	{
		  IgnoreLevel lvl = m.getAnnotation(IgnoreLevel.class);
		  if(lvl!=null)
		  {
			  if (lvl.value().equals("1")) return true;
		  }
		  return super.hasIgnoreMarker(m);
	}*/

}
