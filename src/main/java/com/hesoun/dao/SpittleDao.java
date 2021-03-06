package com.hesoun.dao;


import com.hesoun.entity.Spittle;

import java.util.List;

/**
 * Returns {@param count} Spittles where the latest has {@param max} id.
 *
 * E.g. to return the list of 20 most recent Spittles you can write
 * {@code findSpittles(Integer.MAX_INT,20)}
 *
 * @author Jakub Hesoun
 */
public interface SpittleDao {
    List<Spittle> findSpittles(Long max, Integer count);

    Spittle findOne(Long spittleId);
}

