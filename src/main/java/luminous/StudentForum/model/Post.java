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

@Entity
@Table(name="posts")
public class Post {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Short id;

    @Column(nullable=false, length=200)
    @NotNull(message = "Field can''t leave empty!!")
    @Size(min = 5, message = "Value must be greater than 5 character!!")
    private String title;
    
    @Column(nullable = false, length = 2000)
    @NotNull(message = "Field can''t leave empty!!")
    @Size(min = 10, message = "Value must be greater than 10 character!!")
    private String pbody;

    @Column(nullable = false, columnDefinition = "smallint(6) default 1")
    private Short status = 1;

    @Column(nullable = false, columnDefinition = "smallint(6) default 0")
    private Short views = 0;

    @Column(nullable = false)
    private String createdAt = new Date(System.currentTimeMillis()).toString();


    public Short getId() {
        return this.id;
    }

    public void setId(Short id) {
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

    public Short getStatus() {
        return this.status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public Short getViews() {
        return this.views;
    }

    public void setViews(Short views) {
        this.views = views;
    }

    public String getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
    
}
