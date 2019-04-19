package spring.graphql.simple.resolver;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLResolver;

import lombok.AllArgsConstructor;
import spring.graphql.simple.entity.Author;
import spring.graphql.simple.entity.Book;
import spring.graphql.simple.repo.AuthorRepository;

/**
 * Created by genghz on 18/3/29.
 */
@Component
@AllArgsConstructor
public class BookResolver implements GraphQLResolver<Book> {

    private AuthorRepository authorRepository;

    public Author getAuthor(Book book) {
        Optional<Author> opt = authorRepository.findById(book.getAuthorId());
        return opt.isPresent() ? opt.get() : null;
    }
}