package com.main.S.B.Financial.mappers;

import com.main.S.B.Financial.controller.response.PixResponse;
import com.main.S.B.Financial.controller.response.UserResponse;
import com.main.S.B.Financial.models.PixKey;
import com.main.S.B.Financial.models.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {

    public UserResponse toResponse(User user){
        return new UserResponse(
                user.getId(),
                user.getName(),
                user.getAddress()
        );
    }

    public List<UserResponse> toListResponse (List<User> users){
        return users.stream().map(user -> new UserResponse(
                user.getId(),
                user.getName(),
                user.getAddress()
        )).collect(Collectors.toList());
    }

}
