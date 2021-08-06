package luminous.StudentForum.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="votes")
public class Vote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private int fkPost;

    @Column(nullable = false)
    private String fkUser;

    @Column(nullable = false)
    private int state;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFkPost() {
        return this.fkPost;
    }

    public void setFkPost(int fkPost) {
        this.fkPost = fkPost;
    }

    public String getFkUser() {
        return this.fkUser;
    }

    public void setFkUser(String fkUser) {
        this.fkUser = fkUser;
    }

    public int getState() {
        return this.state;
    }

    public void setState(int state) {
        this.state = state;
    }


    public Vote(int fkPost, String fkUser, int state) {
        this.fkPost = fkPost;
        this.fkUser = fkUser;
        this.state = state;
    }


    public Vote() {
    }


}
