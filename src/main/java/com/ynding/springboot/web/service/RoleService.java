package com.ynding.springboot.web.service;

import com.ynding.springboot.entity.Role;
import com.ynding.springboot.o.bo.GQuery;
import com.ynding.springboot.web.data.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public List<Role> findList(GQuery query){
        return roleRepository.findAll();
    }

    public Page<Role> pageList(GQuery query){

        Pageable pageable =  PageRequest.of(query.getOffset(), query.getLimit(), Sort.Direction.DESC, "id");
        return roleRepository.findAll(pageable);
    }
}
