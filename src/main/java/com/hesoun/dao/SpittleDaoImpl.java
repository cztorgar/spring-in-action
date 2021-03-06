package com.hesoun.dao;

import com.hesoun.entity.Spittle;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Jakub Hesoun
 */
@Repository
public class SpittleDaoImpl implements SpittleDao {
    @Override
    public List<Spittle> findSpittles(Long max, Integer count) {
        //TODO change this constant Spittle list generation
        List<Spittle> spittleList = new ArrayList<Spittle>(count);
        for (int i = 0; i < count; i++) {
            spittleList.add(new Spittle("Spittle " + i, LocalDateTime.now()));
        }
        return spittleList;
    }

    @Override
    public Spittle findOne(Long spittleId) {
        //TODO change this constant Spittle generation
        return new Spittle("Spittle with id= " + spittleId, LocalDateTime.now());
    }
}
