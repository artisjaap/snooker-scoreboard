package be.qnh.gertronic.snooker.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

/**
 * Created by stijn on 17/01/2018.
 */
@MappedSuperclass
public abstract class AbstractEntity {
    @Id
    @Column(name = "ID")
    private Integer id;

    @Column
    private LocalDateTime timestamp = LocalDateTime.now();

    public Integer getId() {
        return id;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AbstractEntity that = (AbstractEntity) o;

        return id != null ? id.equals(that.id) : that.id == null;
    }

    @Override
    public int hashCode() {
        return timestamp.hashCode();
    }
}
