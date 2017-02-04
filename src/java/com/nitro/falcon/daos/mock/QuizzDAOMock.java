package com.nitro.falcon.daos.mock;

import com.nitro.falcon.daos.QuizzDAO;
import com.nitro.falcon.models.Quizz;
import com.nitro.falcon.utils.LongSparseArray;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;

/**
 * QuizzDAOMock
 * @author leops
 */
@Stateless
public class QuizzDAOMock implements QuizzDAO {
    private static final LongSparseArray<Quizz> quizzes = new LongSparseArray<>();
    static {
        final List<String> questions = new ArrayList<>();
        questions.add("Why are final variables only checked by the compiler ?");
        questions.add("Was the primitive boxing nonsense really necessary ?");
        questions.add("Did inner classes really have to be that verbose ?");
        questions.add("What was wrong with whoever designed finalization ?");
        questions.add("Why are unchecked exception still a thing ?");
        
        final Quizz quizz1 = new Quizz();
        quizz1.setId(0);
        quizz1.setQuestions(questions);
        
        quizzes.put(quizz1.getId(), quizz1);
    }

    @Override
    public Quizz findById(final long id) {
        return quizzes.get(id);
    }
}
