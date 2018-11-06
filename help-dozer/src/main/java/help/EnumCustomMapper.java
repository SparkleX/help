package help;

import org.dozer.CustomConverter;

public class EnumCustomMapper implements CustomConverter 
{
    public Object convert(Object destination, Object source, Class destClass, Class sourceClass) 
    {
        if (source == null) 
        {
            return null;
        }

        //Assert.isInstanceOf(Enum.class, source, "Source must be an Enum to work with this CustomConverter");
        final String name = ((Enum) source).name();
        //return Enum.valueOf(destClass, name);
        return 100;
    }
}