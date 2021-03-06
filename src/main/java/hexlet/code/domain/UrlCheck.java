package hexlet.code.domain;

import io.ebean.Model;
import io.ebean.annotation.NotNull;
import io.ebean.annotation.WhenCreated;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Entity
public class UrlCheck extends Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @WhenCreated
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    private final int statusCode;

    private final String title;
    private final String h1;

    @Lob
    private final String description;

    @ManyToOne
    private final Url url;

    public UrlCheck(int pStatusCode, String pTitle, String pH1, String pDescription, Url pUrl) {
        this.statusCode = pStatusCode;
        this.title = pTitle;
        this.h1 = pH1;
        this.description = pDescription;
        this.url = pUrl;
    }

    public final long getId() {
        return id;
    }

    public final Date getCreatedAt() {
        return createdAt;
    }

    public final int getStatusCode() {
        return statusCode;
    }

    public final String getTitle() {
        return title;
    }

    public final String getH1() {
        return h1;
    }

    public final String getDescription() {
        return description;
    }

    public final Url getUrl() {
        return url;
    }
}
