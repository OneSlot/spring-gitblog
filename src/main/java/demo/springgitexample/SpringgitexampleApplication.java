package demo.springgitexample;

import demo.springgitexample.model.Author;
import demo.springgitexample.model.Gender;
import demo.springgitexample.model.Post;
import demo.springgitexample.repository.AuthorRepository;
import demo.springgitexample.repository.PostRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import java.time.LocalDate;

@SpringBootApplication
public class SpringgitexampleApplication {

    private static Logger logger =LoggerFactory.getLogger(SpringgitexampleApplication.class);



    public static void main(String[] args) {
        SpringApplication.run(SpringgitexampleApplication.class, args);
    }


    @Bean @Profile("dev")
    public CommandLineRunner runner(AuthorRepository authorRepository, PostRepository postRepository){
        return args -> {

            Author au1 = new Author("Tun Thu", LocalDate.of(1980,3,21),"Horror", Gender.MALE);
            Author au2 = new Author("ERROR(Si Thu)",LocalDate.of(1980,4,2),"Reading",Gender.MALE);

            Post p1 =new Post("About Teacher","To change education System",LocalDate.of(2019,6,22));
            Post p2 = new Post("Just for Life","Vincent Van Gogh",LocalDate.of(1997,3,2));

            p1.setAuthor(au1);
            p2.setAuthor(au2);
            authorRepository.save(au1);
            authorRepository.save(au2);
            postRepository.save(p1);
            postRepository.save(p2);

            logger.info("successfully created");
        };
    }
}
