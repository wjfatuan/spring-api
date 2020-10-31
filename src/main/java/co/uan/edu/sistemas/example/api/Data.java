package co.uan.edu.sistemas.example.api;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

@Entity
//@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
public class Data {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String name;
    //@Type(type="jsonb")
    //@Column(columnDefinition = "jsonb")
    //@Basic(fetch = FetchType.LAZY)
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
