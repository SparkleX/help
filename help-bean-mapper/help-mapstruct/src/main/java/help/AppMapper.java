package help;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AppMapper 
{

    public static void main(String[] argc)
    {
        BeanA a = new BeanA();
        a.id = 10L;
        a.name = "Filip";
        a.enum1 = EnumA.ONE;
        BeanATax aTax = new BeanATax();
        aTax.tax = "TAX";
        a.taxs = new ArrayList<>( Collections.singleton( aTax ) );
        BeanALine aLine = new BeanALine();
        aLine.lineNum = 100;
        a.lines = new ArrayList<>( Collections.singleton( aLine ) );
        
        BeanALineLine aLineLine = new BeanALineLine();
        aLineLine.a = 999;
        aLine.lineLine = new ArrayList<>( Collections.singleton( aLineLine ) );
        

        BeanB b = BeanAMapper.MAPPER.toBeanB(a);
        System.out.println(b.id2);
        System.out.println(b.name2);
        System.out.println(b.enum2);
        System.out.println(b.lines2.get(0).lineNum2);
        System.out.println(b.lines2.get(0).lineLine2.get(0).a2);
        System.out.println(b.tax.tax);
 
        
    }

 
}
