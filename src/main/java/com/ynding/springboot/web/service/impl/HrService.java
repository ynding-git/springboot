package com.ynding.springboot.web.service.impl;

import com.ynding.springboot.entity.Hr;
import com.ynding.springboot.web.data.HrRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class HrService implements UserDetailsService {

    @Autowired
    private HrRepository hrRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Hr hr = hrRepository.findHrByUsername(s);
        if(hr == null){
            throw new UsernameNotFoundException("用户名不存在");
        }
        return hr;
    }
}
