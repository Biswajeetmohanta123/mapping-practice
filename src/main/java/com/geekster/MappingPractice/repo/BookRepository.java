package com.geekster.MappingPractice.repo;

import com.geekster.MappingPractice.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, String> {
}
