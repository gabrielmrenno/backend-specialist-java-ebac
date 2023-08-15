package main.java.br.com.grenno.dao.generic;

import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

public class Entity {
    private final UUID id;
    private final Date createdAt;

    protected Entity(UUID id) {
        this.id  = (id != null) ? id : UUID.randomUUID();
        this.createdAt = new Date();
    }

    public UUID getId() {
        return id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }
}
