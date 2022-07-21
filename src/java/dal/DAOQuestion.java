/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Answer;
import model.Question;
import model.User;

/**
 *
 * @author duchi
 */
public class DAOQuestion extends DBContext {

    public HashMap<Integer, Question> getQuestions() {
        HashMap<Integer, Question> questions = new HashMap<>();
        try {
            String sql = "SELECT q.[id] as qid\n"
                    + "      ,q.[question] as quest\n"
                    + "      ,q.[date] as datecreate\n"
                    + "	  ,a.[id] as aid\n"
                    + "	  ,a.content as acontent\n"
                    + "	  ,a.correct as isCorrect\n"
                    + "  FROM [dbo].[Question] q INNER JOIN [dbo].[Answer] a ON q.[id] = a.qid";

            PreparedStatement stm = connection.prepareStatement(sql);

            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                int qid = rs.getInt("qid");
                Question q;
                if (questions.get(qid) == null) {
                    String quest = rs.getString("quest");
                    Date date = rs.getDate("datecreate");
                    ArrayList<Answer> answers = new ArrayList<>();
                    q = new Question(qid, quest, date, answers);
                    questions.put(qid, q);
                } else {
                    q = questions.get(qid);
                }
                int aid = rs.getInt("aid");
                String acontent = rs.getString("acontent");
                boolean isCorrect = rs.getBoolean("isCorrect");
                Answer a = new Answer(aid, q, acontent, isCorrect);
                q.getAnswers().add(a);

            }

        } catch (SQLException ex) {
            Logger.getLogger(DAOQuestion.class.getName()).log(Level.SEVERE, null, ex);
        }

        return questions;
    }

    public HashMap<Integer, Question> getYourQuestions(User user) {
        HashMap<Integer, Question> questions = new HashMap<>();
        try {
            String sql = "SELECT q.[id] as qid\n"
                    + "      ,q.[question] as quest\n"
                    + "      ,q.[date] as datecreate\n"
                    + "  FROM [dbo].[Question] q INNER JOIN [dbo].questOnwer qo ON q.[id] = qo.[qid]\n"
                    + "  INNER JOIN [dbo].[User] u ON qo.[user] = u.[name] \n"
                    + "  WHERE u.[name] = ?";

            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, user.getName());
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                int qid = rs.getInt("qid");
                Question q;
                if (questions.get(qid) == null) {
                    String quest = rs.getString("quest");
                    Date date = rs.getDate("datecreate");
                    ArrayList<Answer> answers = new ArrayList<>();
                    q = new Question(qid, quest, date, answers);
                    questions.put(qid, q);
                } else {
                    q = questions.get(qid);
                }

            }

        } catch (SQLException ex) {
            Logger.getLogger(DAOQuestion.class.getName()).log(Level.SEVERE, null, ex);
        }

        return questions;
    }

    public boolean createQuestion(Question question, User user) {
        boolean isSuc = false;
        try {
            String sql = "DECLARE @question varchar(150) = ? \n"
                    + "DECLARE @answer1 varchar(150) = ? \n"
                    + "DECLARE @correct1 bit = ? \n"
                    + "DECLARE @answer2 varchar(150) = ? \n"
                    + "DECLARE @correct2 bit = ? \n"
                    + "DECLARE @answer3 varchar(150) = ? \n"
                    + "DECLARE @correct3 bit = ? \n"
                    + "DECLARE @answer4 varchar(150) = ? \n"
                    + "DECLARE @correct4 bit = ?\n"
                    + "DECLARE @user varchar(150) = ? \n"
                    + "INSERT INTO [dbo].[Question]\n"
                    + "           ([question]\n"
                    + "           ,[date])\n"
                    + "     VALUES\n"
                    + "           ( @question\n"
                    + "           , GETDATE())\n"
                    + "\n"
                    + "DECLARE @qid int =0\n"
                    + "SET @qid =(SELECT(COUNT(id))FROM [dbo].[Question])\n"
                    + "INSERT INTO [dbo].[questOnwer]\n"
                    + "           ([user]\n"
                    + "           ,[qid])\n"
                    + "     VALUES\n"
                    + "           (@user\n"
                    + "           ,@qid)\n"
                    + "INSERT INTO [dbo].[Answer]\n"
                    + "           ([qid]\n"
                    + "           ,[content]\n"
                    + "           ,[correct])\n"
                    + "     VALUES\n"
                    + "           (@qid\n"
                    + "           ,@answer1\n"
                    + "           ,@correct1)\n"
                    + "INSERT INTO [dbo].[Answer]\n"
                    + "           ([qid]\n"
                    + "           ,[content]\n"
                    + "           ,[correct])\n"
                    + "     VALUES\n"
                    + "           (@qid\n"
                    + "           ,@answer2\n"
                    + "           ,@correct2)\n"
                    + "INSERT INTO [dbo].[Answer]\n"
                    + "           ([qid]\n"
                    + "           ,[content]\n"
                    + "           ,[correct])\n"
                    + "     VALUES\n"
                    + "           (@qid\n"
                    + "           ,@answer3\n"
                    + "           ,@correct3)\n"
                    + "\n"
                    + "INSERT INTO [dbo].[Answer]\n"
                    + "           ([qid]\n"
                    + "           ,[content]\n"
                    + "           ,[correct])\n"
                    + "     VALUES\n"
                    + "           (@qid\n"
                    + "           ,@answer4\n"
                    + "           ,@correct4)";

            PreparedStatement stm = connection.prepareStatement(sql);
            int index = 1;
            stm.setString(index, question.getQuest());
            index++;
            for (Answer answer : question.getAnswers()) {
                stm.setString(index, answer.getContent());
                index++;
                stm.setBoolean(index, answer.isIsTrue());
                index++;
            }
            stm.setString(index, user.getName());
            
            int count = stm.executeUpdate();
            System.out.println(count);
            isSuc = (count > 0);

        } catch (SQLException ex) {
            Logger.getLogger(DAOQuestion.class.getName()).log(Level.SEVERE, null, ex);
        }

        return isSuc;
    }
}
