package service;

public class AdministradorServiceFactory {

	public static AdministradorService getAdministradorServiceImpl() {
		return new AdministradorServiceImpl();
	}

}
