package com.chois.payorder.menu.repository;

import com.chois.payorder.menu.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuRepository extends JpaRepository<Menu,Long> {
}
