package spring.graphql.simple.repo;


import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import spring.graphql.simple.entity.Author;

/**
 * Created by genghz on 18/3/27.
 */
public interface AuthorRepository extends PagingAndSortingRepository<Author, Long> {

    List<Author> findAll();
}