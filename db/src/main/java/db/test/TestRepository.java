package db.test;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TestRepository extends JpaRepository<TestEntity, Long> {

    // select * from test_entity order by created_at desc limit 1;
    Optional<TestEntity> findFirstByOrderByCreatedAtDesc();
}
