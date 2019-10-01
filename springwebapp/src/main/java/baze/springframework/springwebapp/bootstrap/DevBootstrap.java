package baze.springframework.springwebapp.bootstrap;

import baze.springframework.springwebapp.model.Author;
import baze.springframework.springwebapp.model.Book;
import baze.springframework.springwebapp.repositories.AuthorRepository;
import baze.springframework.springwebapp.repositories.BookRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    public void initData(){

        //Eric
        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book( "Domain Driven Designer", "1234",  "Harper Collans" );
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
        authorRepository.save(eric);
        bookRepository.save(ddd);

        //Rod
        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("JZEE Dev without EJB", "23344", "Worx");
        rod.getBooks().add(noEJB);
        authorRepository.save(rod);
        bookRepository.save(noEJB);
    }

}
