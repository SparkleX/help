package spring.graphql.simple.resolver;


import java.util.Optional;

import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;

import lombok.AllArgsConstructor;
import spring.graphql.simple.entity.Author;
import spring.graphql.simple.entity.Book;
import spring.graphql.simple.model.BookInput;
import spring.graphql.simple.repo.AuthorRepository;
import spring.graphql.simple.repo.BookRepository;

/**
 * Created by genghz on 18/3/29.
 */
@Component
@AllArgsConstructor
public class Mutation implements GraphQLMutationResolver {

    private AuthorRepository authorRepository;

    private BookRepository bookRepository;


    public Author newAuthor(String firstName, String lastName) {
        Author author = new Author();
        author.setFirstName(firstName);
        author.setLastName(lastName);
        return authorRepository.save(author);
    }

    public Book newBook(String title, String isbn, int pageCount, long authorId) {
        Book book = new Book();
        book.setTitle(title);
        book.setIsbn(isbn);
        book.setPageCount(pageCount);
        book.setAuthorId(authorId);
        return bookRepository.save(book);
    }

    public Book saveBook(BookInput input) {
        Book book = new Book();
        book.setTitle(input.getTitle());
        book.setIsbn(input.getIsbn());
        book.setPageCount(input.getPageCount());
        book.setAuthorId(input.getAuthorId());
        return bookRepository.save(book);
    }

    public Boolean deleteBook(long id) {
        bookRepository.deleteById(id);
        return true;
    }

    public Book updateBookPageCount(int pageCount, long id) {
        Optional<Book> opt = bookRepository.findById(id);
        if (!opt.isPresent()) return null;

        Book book = opt.get();
        book.setPageCount(pageCount);
        return bookRepository.save(book);
    }
}