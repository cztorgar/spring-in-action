package com.hesoun.dao;

import com.hesoun.entity.Spitter;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

/**
 * Dao class for Spitter objects
 *
 * @author Jakub Hesoun
 */
@Repository
public class SpitterDaoImpl implements SpitterDao {

    private final Map<String, Spitter> spitters = new HashMap<>();

    {
        spitters.put("tomjones", new Spitter("tomjones", "Tom", "Jones", "tomjones"));
    }

    @Override
    public Spitter findByUsername(String username) {
        //TODO change this basic testing implementation
        return spitters.get(username);
    }

    @Override
    public void save(Spitter spitter) {
        spitters.put(spitter.getUsername(), spitter);
    }
}
