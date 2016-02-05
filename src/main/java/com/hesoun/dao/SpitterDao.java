package com.hesoun.dao;

import com.hesoun.entity.Spitter;

/**
 * @author Jakub Hesoun
 */
public interface SpitterDao {

    Spitter findByUsername(String username);
    void save(Spitter spitter);
}
