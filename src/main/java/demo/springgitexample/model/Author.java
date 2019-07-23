package demo.springgitexample.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Data
public class Author implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate localDate;
    private String interested;

    @Enumerated(EnumType.STRING)
    private Gender gender;


    public Author(){

    }

    public Author(String name,LocalDate date,String interested,Gender gender){
        this.name =name;
        this.localDate=date;
        this.interested=interested;
        this.gender =gender;
    }
}
