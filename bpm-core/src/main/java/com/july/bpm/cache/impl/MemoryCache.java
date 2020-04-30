package com.july.bpm.cache.impl;

import com.july.bpm.cache.ICache;
import com.july.bpm.constant.BaseStatusCode;
import com.july.bpm.exception.BusinessException;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 内存的cache实现。
 * @author jeff
 */
public class MemoryCache<T> implements ICache<T> {

    private Map<String, T> map = new ConcurrentHashMap<>();

    @Override
    public void add(String key, T obj) {
        if (key == null) {
            return;
        }
        map.put(key, obj);
    }

    @Override
    public void delByKey(String key) {
        if (key == null) {
            return;
        }
        map.remove(key);
    }

    @Override
    public void clearAll() {
        map.clear();
    }

    @Override
    public T getByKey(String key) {
        if (key == null) {
            return null;
        }
        return map.get(key);
    }

    @Override
    public boolean containKey(String key) {
        if (key == null) {
            return false;
        }
        return map.containsKey(key);
    }

    @Override
    public void add(String key, T obj, int timeout) {
        throw new BusinessException(BaseStatusCode.NOT_SUPPORT);
    }

    @Override
    public void add2Region(String region, String key, T obj) {
        this.add(key, obj);
    }

    @Override
    public T getByKey(String region, String key) {
        return this.getByKey(key);
    }

    @Override
    public void clearRegion(String region) {

    }

    @Override
    public void delByKey(String region, String key) {
        this.delByKey(key);
    }

    @Override
    public boolean containKey(String region, String key) {
        return this.containKey(key);
    }

}
