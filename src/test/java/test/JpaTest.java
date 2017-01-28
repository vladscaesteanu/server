/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;
import com.server.model.User;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
 
public class JpaTest {
    private static EntityManager em;
 
    public static void main(String[] args) {
 
        EntityManagerFactory emf = Persistence
                .createEntityManagerFactory("EmployeePU");
        em = emf.createEntityManager();
 
        createEmployee(1, "Ravi", "Raj", "Textile", "sex");
        createEmployee(2, "Amit", "Raj", "IT", "sex");
        createEmployee(3, "Nitish", "Kumar", "Marketing", "sex");
 
    }
 
    private static void createEmployee(long id, String userName,
            String password, String name, String email) {
        em.getTransaction().begin();
        User emp = new User(id, userName, password, name,email);
        em.persist(emp);
        em.getTransaction().commit();
    }
}

