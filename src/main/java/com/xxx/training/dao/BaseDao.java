/**
 * 
 */
package com.xxx.training.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;
import java.util.List;





/**
 * @author xxx
 * @param <T>
 *
 */
@NoRepositoryBean
public interface BaseDao<T,ID extends Serializable> extends CrudRepository<T, Serializable> {
	Page<T> findAll(Specification<T> spec, Pageable pageable);
    List<T> findAll();
}
