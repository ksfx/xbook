package de.xbook.model.media;

import de.xbook.model.user.User;

import javax.persistence.*;
import java.util.Date;

@SuppressWarnings("serial")
@Entity
@Table(name = "item")
public class Media
{
    private Long id;
    private String title;
    private byte[] content;
    private User user;
    private Date created;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public byte[] getContent()
    {
        return content;
    }

    public void setContent(byte[] content)
    {
        this.content = content;
    }

    @Column(name="xbookuser")
    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
    }

    public Date getCreated()
    {
        return created;
    }

    public void setCreated(Date created)
    {
        this.created = created;
    }
}
