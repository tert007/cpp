package dao;

import dao.factoryimpl.DatabaseDaoFactory;

public abstract class DaoFactory {

	public static DaoFactory getDaoFactory(){
		switch ("database") {
			case "database":
				return DatabaseDaoFactory.getInstance();
		}

		return null;
	}

	public abstract UserDao getUserDao();
}
