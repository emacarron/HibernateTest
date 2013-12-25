package net.javabeat.hibernate;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

/**
 * Hello world!
 * 
 */
public class App {

  @Test
  public void run() {
    System.out.println("Maven + Hibernate + HSQL");
    saveContact("Jiya");
//    saveContact("Manisha");
//    saveContact("Riya");
//    listContact();
  }

  /*
   * Save the data to database table
   */
  public Integer saveContact(String contactName) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    Integer contactId = null;
    Transaction transaction = session.beginTransaction();
    try {      
      Contact contact = new Contact();
      contact.setName(contactName);
      contactId = (Integer) session.save(contact);
      transaction.commit();
    } catch (HibernateException e) {
      transaction.rollback();
      e.printStackTrace();
    } finally {
      session.close();
    }
    return contactId;
  }

  /*
   * Lists the contacts from database table
   */
  public void listContact() {
    Session session = HibernateUtil.getSessionFactory().openSession();
    Transaction transaction = null;
    try {
      transaction = session.beginTransaction();
      @SuppressWarnings("unchecked")
      List<Contact> contactList = session.createQuery("from Contact").list();
      for (Iterator<Contact> iterator = contactList.iterator(); iterator.hasNext();) {
        Contact contact = (Contact) iterator.next();
        System.out.println(contact.getName());
      }
      transaction.commit();
    } catch (HibernateException e) {
      transaction.rollback();
      e.printStackTrace();
    } finally {
      session.close();
    }
  }

}