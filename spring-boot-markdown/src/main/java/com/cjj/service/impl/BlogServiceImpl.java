package com.cjj.service.impl;

import com.cjj.repository.BlogRepository;
import com.cjj.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述：
 *
 * @author littlecar
 * @date 2019/8/28 17:01
 */
@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    private BlogRepository blogrepository;

}
