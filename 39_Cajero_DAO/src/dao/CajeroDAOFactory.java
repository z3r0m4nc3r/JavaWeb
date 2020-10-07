package dao;

public class CajeroDAOFactory {
	
	public static CajeroDAO getCajeroDAO(){
		return new CajeroDaoImplJdbc();
	}

}
