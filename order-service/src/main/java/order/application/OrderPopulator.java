package order.application;

public interface OrderPopulator<C, R>
{
	R populate(C fromType);
}
