package co.uan.edu.sistemas.example.api;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
// import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

@DataJpaTest
public class DataRepositoryTest {

    // @Autowired
    // private TestEntityManager entityManager;

    @Autowired
    private DataRepository repository;

    @Test
    public void emptyRepository() {
        Iterable<Data> data = repository.findAll();
        assertThat(data).isEmpty();
    }

    
}
