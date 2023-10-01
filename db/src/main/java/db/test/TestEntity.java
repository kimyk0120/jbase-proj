package db.test;

import db.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@SuperBuilder
@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "test_tbl")
@NoArgsConstructor
public class TestEntity  extends BaseEntity {

    private String memo;
    private Integer amount;
    private LocalDateTime modifiedAt;
    private LocalDateTime createdAt;

}
