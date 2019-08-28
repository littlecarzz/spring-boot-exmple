package com.cjj.repository;

import com.cjj.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 描述：
 *
 * @author littlecar
 * @date 2019/8/28 16:59
 */
@Repository
public interface BlogRepository extends JpaRepository<Blog,Long> {
     Blog findBlogById(Long id);
}
