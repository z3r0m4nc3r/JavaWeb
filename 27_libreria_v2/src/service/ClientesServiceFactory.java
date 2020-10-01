package service;

public class ClientesServiceFactory {
	public static ClientesService getLibrosService() {
		return new ClientesServiceImpl();
	}

}
