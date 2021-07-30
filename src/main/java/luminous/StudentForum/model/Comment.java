package luminous.StudentForum.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import jdk.jfr.Timestamp;

@Entity
@Table(name="comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(nullable = false, length = 16000)
    @NotNull(message = "Field can''t leave empty!!")
    @Size(min = 10, message = "Value must be greater than 4 character!!")
    private String ctext;

    @Column(nullable = false)
    private int frPost;

    @Column(nullable = false)
    private String frUser;

    @Timestamp
    @Column(nullable = false)
    private Date createdAt = new Date(System.currentTimeMillis());


    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCtext() {
        return this.ctext;
    }

    public void setCtext(String ctext) {
        this.ctext = ctext;
    }

    public int getFrPost() {
        return this.frPost;
    }

    public void setFrPost(int frPost) {
        this.frPost = frPost;
    }

    public String getFrUser() {
        return this.frUser;
    }

    public void setFrUser(String frUser) {
        this.frUser = frUser;
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }


    public Comment(String ctext, int frPost, String frUser) {
        this.ctext = ctext;
        this.frPost = frPost;
        this.frUser = frUser;
    }



    public Comment() {
    }


    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", ctext='" + getCtext() + "'" +
            ", frPost='" + getFrPost() + "'" +
            ", frUser='" + getFrUser() + "'" +
            ", createdAt='" + getCreatedAt() + "'" +
            "}";
    }


}
