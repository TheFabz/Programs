package org.academiadecodigo.asynctomatics;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.RollbackException;

public class Test {

    private EntityManagerFactory emf;

    public Test() {
        emf = Persistence.createEntityManagerFactory("user");
    }

    public static void main(String[] args) {

        Test test = new Test();

        User user = new User();

        user.setId(2);
        user.setName("Fábia");
        user.setEmail("ff.rodrigues@gmail.com");
        user.setPhone(412121212);

        System.out.println("---- Persisting user ----");
        test.save(user);


        System.out.println(test.fetch(user.getId()));
    }

    private void save(User user) {

        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(user);
            em.getTransaction().commit();

        } catch(RollbackException ex) {
            em.getTransaction().rollback();

        } finally {
            em.close();
        }
    }

    private User fetch(Integer id) {

        EntityManager em = emf.createEntityManager();

        try {
            return em.find(User.class, id);

        } finally {
            em.close();
        }

    }
}
