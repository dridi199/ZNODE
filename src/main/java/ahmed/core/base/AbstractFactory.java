package ahmed.core.base;


/**
 * @author ahmed
 */

public abstract class AbstractFactory {
	  public abstract Recordable createRecord(String criteria) throws CustomException;

}
