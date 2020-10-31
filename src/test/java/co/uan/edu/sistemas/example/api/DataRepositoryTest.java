package co.uan.edu.sistemas.example.api;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

@DataJpaTest
public class DataRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private DataRepository repository;

    @Test
    public void emptyRepository() {
        Iterable<Data> data = repository.findAll();
        assertThat(data).isEmpty();
    }

    @Test
    public void createData() {
        Data data = repository.save(new Data("test","{'name':'test data'}"));
        
        assertThat(data).hasFieldOrPropertyWithValue("name", "test");
        assertThat(data).hasFieldOrPropertyWithValue("data", "{'name':'test data'}");

    }

    @Test
    public void dataString() {
        Data data = new Data("test","{'name':'test data'}");
        
        assertThat(data.toString()).contains("test");
        assertThat(data.toString()).contains("{'name':'test data'}");

    }

    @Test
    public void findAllData() {
        Data data1 = entityManager.persist(new Data("test","{'name':'test data 1'}"));
        Data data2 = entityManager.persist(new Data("test","{'name':'test data 2'}"));
        Data data3 = entityManager.persist(new Data("test","{'name':'test data 3'}"));
        
        Iterable<Data> data = repository.findAll();
        assertThat(data).hasSize(3).contains(data1 ,data2, data3);

    }

    @Test
    public void findById() {
        Data data1 = new Data("test","{'name':'test data 1'}");
        entityManager.persist(data1);
        Data data2 = entityManager.persist(new Data("test","{'name':'test data 2'}"));
        
        Data data = repository.findById(data2.getId()).get();
        assertThat(data).isEqualTo(data2);

    }

    @Test
    public void findByName() {
        Data data1 = new Data("notest","{'name':'test data 1'}");
        entityManager.persist(data1);
        Data data2 = entityManager.persist(new Data("test","{'name':'test data 2'}"));
        
        Iterable<Data> data = repository.findByName("test");
        assertThat(data).hasSize(1).contains(data2).doesNotContain(data1);

    }

    @Test
    public void delete() {
        Data data1 = new Data("notest","{'name':'test data 1'}");
        entityManager.persist(data1);
        Data data2 = entityManager.persist(new Data("test","{'name':'test data 2'}"));
        Data data3 = entityManager.persist(new Data("test","{'name':'test data 3'}"));

        repository.deleteById(data2.getId());
        
        Iterable<Data> data = repository.findAll();
        assertThat(data).hasSize(2).contains(data1,data3).doesNotContain(data2);

    }

}
