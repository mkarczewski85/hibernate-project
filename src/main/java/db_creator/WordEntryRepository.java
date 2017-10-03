package db_creator;

import hibernate.utils.HibernateUtil;
import org.hibernate.Session;

import javax.persistence.Query;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class WordEntryRepository {

    public static boolean addWordEntry(WordEntry entry) {
        Session session = null;
        try {
            session = HibernateUtil.openSession();
            session.save(entry);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }

    }

    public static List<WordEntry> findWordsByChars(Set<String> charsList) {
        Session session = null;

        try {
            session = HibernateUtil.openSession();
            String hql = "SELECT e FROM WordEntry e WHERE LOWER(e.sortedChars) IN (:chars)";
            Query query = session.createQuery(hql).setParameterList("chars", charsList);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public static List<WordEntry> findWordsByCharsAndScore(Set<String> charsList, Integer score) {
        Session session = null;

        try {
            session = HibernateUtil.openSession();
            String hql = "SELECT e FROM WordEntry e WHERE LOWER(e.sortedChars) IN (:chars) AND e.points > :score";
            Query query = session.createQuery(hql)
                    .setParameterList("chars", charsList)
                    .setParameter("score", score);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

}
