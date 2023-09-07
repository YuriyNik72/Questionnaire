package ru.nikitin.repositories;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.nikitin.entities.Answer;
import ru.nikitin.entities.Question;
import ru.nikitin.entities.User;

import java.util.List;
import java.util.Optional;

@Repository
//public interface QuestionRepository extends PagingAndSortingRepository<Question, Long> {
public interface QuestionRepository extends CrudRepository<Question, Long> {

//    Question findOneByTitle(String title);
    Optional<Question> findById(Long id);
    List<Question> findAll();
//    public void save(Question question, Answer answer1, Answer answer2, Answer answer3);


//    List<Answer> findAllByTitleAndPrice(String title, double price);


//    List<Answer> findAllByPriceBetween(double min, double max);

//    Product findOneByTitleAndId(String title, Long id);
//
//  //  Product findOneByVendorCode
//
//Answer findOneByName(String name);


//    @Query(value ="select id, questions_id,  " +
//            "create_at,  title,  " +
//            "title from answers where id = ?1", nativeQuery = true)
//    Answer myQuery(Long id);




//
//    Iterable<Product> findAll(Sort sort);
}
