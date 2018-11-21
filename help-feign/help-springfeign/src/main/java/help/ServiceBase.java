package help;

public interface ServiceBase<T_Type> 
{
	abstract T_Type call(T_Type type);
}
