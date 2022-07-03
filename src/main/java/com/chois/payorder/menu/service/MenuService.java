package com.chois.payorder.menu.service;

import com.chois.payorder.menu.entity.Menu;
import com.chois.payorder.menu.repository.MenuRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class MenuService {
    private final MenuRepository menuRepository;

    public List<Menu> findMenuList(){
        return menuRepository.findAll();
    }

    public Optional<Menu> findMenuOne(long id){
        return menuRepository.findById(id);
    }
}
