package org.zerock.topik.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.zerock.topik.domain.ReadingQuestion;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

@Component
public class ReadingQuestionRepository {


    private EntityManagerFactory emf;

    @Autowired
    public ReadingQuestionRepository(EntityManagerFactory emf){
        this.emf = emf;
    }

    public List<ReadingQuestion> getAll(){
        EntityManager em = emf.createEntityManager();
        String sql = "SELECT * FROM ReadingQuestion";
        Query query = em.createQuery(sql,ReadingQuestion.class);
        return query.getResultList();
    }

    //random 조회는 jpql지원 x. native query가 필요.
    public List<ReadingQuestion> getRandomQuestion(int count){
        EntityManager em = emf.createEntityManager();
        String sql = "SELECT * FROM TB_READING_QUESTION ORDER BY rand() LIMIT ?";
        Query nativeQuery = em.createNativeQuery(sql,ReadingQuestion.class).setParameter(1,count);
        return nativeQuery.getResultList();
    }

    public void addQuestion(ReadingQuestion newQuestion){
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {
            em.persist(newQuestion);
            tx.commit();
        }
        catch(Exception e){
            tx.rollback();
            throw e;
        }
        finally {
            em.close();
        }
    }


}