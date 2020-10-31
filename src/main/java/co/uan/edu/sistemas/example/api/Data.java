package co.uan.edu.sistemas.example.api;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Data {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String name;
    private String data;

    protected Data() {}

    public Data(String name, String data) {
        this.name = name;
        this.data = data;
    }

    @Override
    public String toString() {
        return String.format("{id=%d, name=%s, data=%s}", id, name, data);
    }

    public String getData() {
        return data;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}
