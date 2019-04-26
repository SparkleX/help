package spring.graphql.simple.resolver;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;

import lombok.AllArgsConstructor;
import spring.graphql.simple.entity.Author;
import spring.graphql.simple.entity.Book;
import spring.graphql.simple.repo.AuthorRepository;
import spring.graphql.simple.repo.BookRepository;

/**
 * Created by genghz on 18/3/28.
 */
@Component
@AllArgsConstructor
public class Query implements GraphQLQueryResolver {

	@Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookRepository bookRepository;

    public Author findOneAuthor(Long id) {
        Optional<Author> opt = authorRepository.findById(id);
        return opt.isPresent() ? opt.get() : null;
    }

    public List<Author> findAllAuthors() {
        return authorRepository.findAll();
    }

    public Long countAuthors() {
        return authorRepository.count();
    }

    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    public Long countBooks() {
        return bookRepository.count();
    }
}