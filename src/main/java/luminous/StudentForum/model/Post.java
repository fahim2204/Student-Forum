package luminous.StudentForum.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import jdk.jfr.Timestamp;

@Entity
@Table(name="posts")
public class Post {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(nullable=false, length=200)
    @NotNull(message = "Field can''t leave empty!!")
    @Size(min = 5, message = "Value must be greater than 5 character!!")
    private String title;
    
    @Column(nullable = false, length = 16000)
    @NotNull(message = "Field can''t leave empty!!")
    @Size(min = 20, message = "Value must be greater than 10 character!!")
    private String pbody;

    @Column(nullable = false, columnDefinition = "smallint(6) default 1")
    private int status = 1;
    
    @Timestamp
    @Column(nullable = false)
    private Date createdAt = new Date(System.currentTimeMillis());

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPbody() {
        return this.pbody;
    }

    public void setPbody(String pbody) {
        this.pbody = pbody;
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
   

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", title='" + getTitle() + "'" +
            ", pbody='" + getPbody() + "'" +
            ", status='" + getStatus() + "'" +
            ", createdAt='" + getCreatedAt() + "'" +
            "}";
    }
    
}
