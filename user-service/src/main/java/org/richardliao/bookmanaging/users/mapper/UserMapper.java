package org.richardliao.bookmanaging.users.mapper;

import java.util.List;
import java.util.Map;

import org.richardliao.bookmanaging.users.domain.User;

public interface UserMapper {
    List<User> getUserList(Map<String, String> query);

    User getUserById(String id);

    int add(User user);

    int update(User user);

    int delete(String id);
}
