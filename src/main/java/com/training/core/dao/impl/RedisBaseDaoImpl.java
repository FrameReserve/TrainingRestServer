package com.training.core.dao.impl;

import java.io.Serializable;

import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.google.gson.Gson;
import com.training.core.dao.RedisBaseDao;
import com.training.core.entity.BaseEntity;

@Repository("redisBaseDao")
public class RedisBaseDaoImpl<T extends BaseEntity> implements RedisBaseDao<T> {

    protected RedisTemplate<Serializable, Serializable> redisTemplate;

	@Override
	public T getEntityById(final Class<T> cls, final Integer id) {
		return redisTemplate.execute(new RedisCallback<T>() {
            @Override
            public T doInRedis(RedisConnection connection) throws DataAccessException {
                byte[] key = redisTemplate.getStringSerializer().serialize(cls.getName() + "_" + id);
                if (connection.exists(key)) {
                    byte[] value = connection.get(key);
                    String json = redisTemplate.getStringSerializer().deserialize(value);
                    return new Gson().fromJson(json, cls);
                }
                return null;
            }
        });
	}
	
    public void addEntity(final T entity) {
        redisTemplate.execute(new RedisCallback<Object>() {

            @Override
            public Object doInRedis(RedisConnection connection) throws DataAccessException {
                connection.set(redisTemplate.getStringSerializer().serialize(entity.getClass().getName() + "_" + entity.getId()),
                               redisTemplate.getStringSerializer().serialize(new Gson().toJson(entity)));
                return null;
            }
        });
    }

	@Override
	public void updateEntity(T entity) {
		this.addEntity(entity);
	}

	@Override
	public void deleteEntityById(final Class<T> cls, final Integer id) {
		redisTemplate.execute(new RedisCallback<Object>() {

            @Override
            public Object doInRedis(RedisConnection connection) throws DataAccessException {
                connection.del(redisTemplate.getStringSerializer().serialize(cls.getName() + "_" + id));
                return null;
            }
        });
		
	}

    public void setRedisTemplate(RedisTemplate<Serializable, Serializable> redisTemplate) {
		this.redisTemplate = redisTemplate;
	}
    
}
