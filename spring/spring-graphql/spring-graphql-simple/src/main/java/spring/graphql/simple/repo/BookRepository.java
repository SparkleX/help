package spring.graphql.simple.repo;


import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import spring.graphql.simple.entity.Book;

/**
 * Created by genghz on 18/3/29.
 */
public interface BookRepository extends PagingAndSortingRepository<Book, Long> {
    List<Book> findAll();

    List<Book> findByAuthorId(Long id);
}