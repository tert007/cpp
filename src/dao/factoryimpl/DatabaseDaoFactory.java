package dao.factoryimpl;

import dao.*;
import dao.database.DatabaseCreateDao;
import dao.database.DatabaseReadDao;

/**
 * Created by Alexander on 16.02.2016.
 */
public class DatabaseDaoFactory extends DaoFactory {
    private final static DatabaseDaoFactory instance = new DatabaseDaoFactory();

    private DatabaseDaoFactory() {
    }

    public final static DatabaseDaoFactory getInstance() {
        return instance;
    }

    @Override
    public CreateDao getCreateDao() {
        return null;
    }

    @Override
    public ReadDao getReadDao() {
        return DatabaseReadDao.getInstance();
    }

    @Override
    public UpdateDao getUpdateDao() {
        return null;
    }

    @Override
    public DeleteDao getDeleteDao() {
        return null;
    }
}
