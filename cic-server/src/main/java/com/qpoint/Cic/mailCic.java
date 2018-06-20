
package com.qpoint.Cic;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="mailCic")
@Table(name="mailCic")
public class mailCic {
    
   @Id
   @ManyToOne
   @PrimaryKeyJoinColumn
   private Email CicId;

   @Column(name = "CicType")
   private String CicType;
   @Column(name = "Subject")
   private String Subject;
   @Column(name = "Body")
   private String Body;
   @Column(name = "SourceSystem")
   private String SourceSystem;
   @Column(name = "CicTimeStamp")
   private DateTime CicTimeStamp;
   
    public Email getId() {
        return CicId;
    }
     public void setId(Email id) {
        this.CicId = id;
    }

    public String getSubjectt() {
        return Subject;
    }

    public void setSubject(String Subject) {
        this.Subject = Subjectnt;
    }

    public String getBody() {
        return Body;
    }

    public void setBody(String Body) {
        this.Body = Body;
    }

    public String getSourceSystem() {
        return SourceSystem;
    }

    public void setSourceSystem(String SourceSystem) {
        this.SourceSystem = SourceSystem;
    }

    public String getCicTimeStampy() {
        return CicTimeStamp;
    }

    public void setCicTimeStamp(DateTime CicTimeStamp) {
        this.CicTimeStamp = CicTimeStamp;
    }

}
