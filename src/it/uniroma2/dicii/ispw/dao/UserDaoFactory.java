package it.uniroma2.dicii.ispw.dao;

import it.uniroma2.dicii.ispw.core.interfaces.UserDao;
import it.uniroma2.dicii.ispw.dao.db.MySqlUserDao;
import it.uniroma2.dicii.ispw.dao.db.PGUserDao;
import it.uniroma2.dicii.ispw.dao.file.FileUserDao;

public class UserDaoFactory {

    public UserDao getUserDAO(Persistence type) throws Exception{

        switch (type) {

            case PostgreSQL: return new PGUserDao();
            case File: return new FileUserDao();
            case MySQL: return new MySqlUserDao();
            default: throw new Exception("Invalid type : " + type);

        }
    }
}
