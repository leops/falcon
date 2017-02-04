package com.nitro.falcon.views;

import com.nitro.falcon.daos.QuizzDAO;
import com.nitro.falcon.models.Quizz;
import com.nitro.falcon.utils.FaceUtils;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

/**
 * QuizzView
 * @author leops
 */
@ManagedBean(name = "quizzView")
@ViewScoped
public class QuizzView implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private Quizz quizz;
    
    @EJB(beanName=QuizzDAO.IMPL_NAME)
    private QuizzDAO quizzDAO;
    
    @ManagedProperty("#{sessionData}")
    private SessionData sessionData;
    
    @PostConstruct
    public void checkLogin() {
        if(!sessionData.isLogged()) {
            FaceUtils.redirect("index");
        }
    }

    public long getQuizzId() {
        return quizz == null ? -1 : quizz.getId();
    }

    public void setQuizzId(final long quizzId) {
        this.quizz = quizzDAO.findById(quizzId);
    }

    public Quizz getQuizz() {
        return quizz;
    }
    
    public void setSessionData(SessionData session) {
        this.sessionData = session;
    }
    
    public void passQuizz() {
        sessionData.getUser().passQuizz(quizz);
        FaceUtils.redirect("index");
    }
}
