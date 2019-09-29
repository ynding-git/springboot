package com.ynding.springboot.web.service;

import com.ynding.springboot.common.UserUtils;
import com.ynding.springboot.entity.Menu;
import com.ynding.springboot.web.data.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class MenuService {

    @Autowired
    MenuRepository menuRepository;

}
