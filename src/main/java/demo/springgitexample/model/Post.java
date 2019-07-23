package demo.springgitexample.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Data
public class Post implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tag;

    //To change binary data...
    @Lob
    @Column(length=100000)
    private String body;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate lastUpdated;

    @ManyToOne
    private Author author;

    public Post(String tag, String body, LocalDate lastUpdated) {
        this.tag = tag;
        this.body = body;
        this.lastUpdated = lastUpdated;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public LocalDate getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(LocalDate lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
