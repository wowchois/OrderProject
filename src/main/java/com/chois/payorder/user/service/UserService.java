package com.chois.payorder.user.service;

import com.chois.payorder.user.dto.UserDto;
import com.chois.payorder.user.entity.User;
import com.chois.payorder.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    @Transactional(rollbackOn = {Exception.class})
    public User addUpdateUser(UserDto user){
        User target = user.toEntity();
        Optional<User> findUser = findUserOne(target.getId());

        if(findUser.isPresent()){
            User nowUser = findUser.get();
            int charge = nowUser.getPoints() + target.getPoints();
            User uptUser = User.builder().id(target.getId()).points(charge).build();

            return saveUser(uptUser);
        }else{
            return saveUser(target);
        }
    }

    public User updatePoint(long id, int point){
        User uptUser = new UserDto(id, point).toEntity();
        return saveUser(uptUser);
    }

    public Optional<User> findUserOne(long id){
        return userRepository.findById(id);
    }

    public User saveUser(User user){
        return userRepository.save(user);
    }

}
