package help.multiple;

public class AppMultiple 
{

    public static void main(String[] argc)
    {
    	BeanA a = new BeanA();
    	a.id = 123;
    	a.address = new BeanAAddress();
    	a.address.addr = "aaa";
    	a.tax = new BeanATax();
    	a.tax.tax = "TAX";
    	
        BeanB b = BeanAMapper.MAPPER.toBean(a);
        System.out.println(b.id);
        System.out.println(b.lines);
        System.out.println(b.lines.get(0).addr);
        System.out.println(b.lines.get(0).tax);
 
        BeanA a2 = BeanAMapper.MAPPER.fromBean(b);
        System.out.println(a2.id);
        System.out.println(a2.address.addr);
        System.out.println(a2.tax.tax);
    }

 
}
