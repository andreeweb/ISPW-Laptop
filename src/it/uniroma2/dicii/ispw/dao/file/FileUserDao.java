package it.uniroma2.dicii.ispw.dao.file;

import it.uniroma2.dicii.ispw.core.interfaces.UserDao;
import it.uniroma2.dicii.ispw.core.model.User;
import it.uniroma2.dicii.ispw.exception.UserDaoException;

public class FileUserDao implements UserDao{

    @Override
    public User getUserByUsernameAndPassword(String username, String password) throws UserDaoException {
        return null;
    }
}