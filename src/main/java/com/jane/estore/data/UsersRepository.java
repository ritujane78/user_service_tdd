package com.jane.estore.data;

import com.jane.estore.model.User;

public interface UsersRepository {
    boolean save(User user);
}
