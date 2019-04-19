package spring.graphql.simple.resolver;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLResolver;

import lombok.AllArgsConstructor;
import spring.graphql.simple.entity.Author;
import spring.graphql.simple.entity.Book;
import spring.graphql.simple.repo.BookRepository;

/**
 * Created by genghz on 18/3/29.
 */
@Component
@AllArgsConstructor
public class AuthorResolver implements GraphQLResolver<Author> {

    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private BookRepository bookRepository;

    public String getCreatedTime(Author author) {
        return sdf.format(author.getCreatedTime());
    }

    public List<Book> getBooks(Author author) {
        return bookRepository.findByAuthorId(author.getId());
    }
}