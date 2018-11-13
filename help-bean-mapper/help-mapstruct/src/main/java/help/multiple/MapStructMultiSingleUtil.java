package help.multiple;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang3.reflect.MethodUtils;
import org.mapstruct.factory.Mappers;
@SuppressWarnings({"rawtypes" })
public class MapStructMultiSingleUtil 
{

	public static void multiToSingle(Object src, Object tgt, String srcAttr, String tgtAttr, String mapperClass, String method) 
	{
		try 
		{
			List list = (List) PropertyUtils.getProperty(src, srcAttr);
			if (list == null || list.size() == 0) 
			{
				return;
			}
			Object mapper = Mappers.getMapper(Class.forName(mapperClass));
			Object obj = MethodUtils.invokeMethod(mapper, method, list.get(0));
			PropertyUtils.setProperty(tgt, tgtAttr, obj);
		} catch (Exception ex) 
		{
			throw new RuntimeException(ex);
		}

	}
	
	@SuppressWarnings("unchecked")
	public static void singleToMulti(Object src, Object tgt, String srcAttr, String tgtAttr, String mapperClass, String method) {
		try {
			Object srcValue = PropertyUtils.getProperty(src, srcAttr);
			Object tgtValue = PropertyUtils.getProperty(tgt, tgtAttr);
			if(srcValue==null)
			{
				return;
			}
			if (tgtValue == null) {
				tgtValue = new ArrayList();
				PropertyUtils.setProperty(tgt, tgtAttr, tgtValue);
			}
			List tgtList = (List) tgtValue;
			Object mapper = Mappers.getMapper(Class.forName(mapperClass));
			Method m = MethodUtils.getAccessibleMethod(mapper.getClass(), method, srcValue.getClass());
			if (tgtList.size() == 0) 
			{
				Object temp = m.getReturnType().newInstance();
				tgtList.add(temp);
			}
			tgtValue = tgtList.get(0);
			Object obj = MethodUtils.invokeMethod(mapper, method, srcValue);
			BeanUtilsBean notNull=new NullAwareBeanUtilsBean();
			notNull.copyProperties(tgtValue, obj);
			
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}

	}
}

class NullAwareBeanUtilsBean extends BeanUtilsBean
{
    @Override
    public void copyProperty(Object dest, String name, Object value)
            throws IllegalAccessException, InvocationTargetException {
        if(value==null)return;
        super.copyProperty(dest, name, value);
    }

}
