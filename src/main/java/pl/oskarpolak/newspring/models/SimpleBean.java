package pl.oskarpolak.newspring.models;

import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * Created by OskarPraca on 2017-05-27.
 */

@Service
public class SimpleBean {
    public String generateString() {
        return UUID.randomUUID().toString();
    }
}
