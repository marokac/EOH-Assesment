
package com.qpoint.Cic;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="Email")
@Table(name="Email")
public class Email {
    
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int EmailId;

   @Column(name = "EmailName")
   private String EmailName;

   @Column(name = "EmailAdress")
   private String EmailAdress;

    public int getId() {
        return EmailId;
    }
     public void setId(int id) {
        this.EmailId = id;
    }

    public String getEmailName() {
        return EmailName;
    }

    public void setEmailName(String EmailAdress) {
        this.EmailName = EmailName;
    }

    public String getEmailAdress() {
        return EmailAdress;
    }

    public void setEmailAdress(String EmailAdress) {
        this.EmailAdress = EmailAdress;
    }
  

}
