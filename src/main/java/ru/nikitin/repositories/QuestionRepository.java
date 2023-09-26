package ru.nikitin.repositories;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.nikitin.entities.Question;

import java.util.List;


@Repository
//public interface QuestionRepository extends PagingAndSortingRepository<Question, Long> {
public interface QuestionRepository extends CrudRepository<Question, Long> {

    Question findOneByQuestion(String question);
//    Optional<Question> findById(Long id);
    Question findQuestionById(Long id);
    List<Question> findAll();
    @Override
    Question save(Question question);


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
