package it.uniroma2.dicii.ispw.core.dao;

import it.uniroma2.dicii.ispw.core.interfaces.UserDao;

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
