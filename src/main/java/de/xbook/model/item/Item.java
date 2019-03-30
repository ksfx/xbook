package de.xbook.model.item;

import de.xbook.model.user.User;

import javax.persistence.*;
import java.util.Date;

@SuppressWarnings("serial")
@Entity
@Table(name = "item")
public class Item
{
    private Long id;
    private String title;
    private String content;
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

    public String getContent()
    {
        return content;
    }

    public void setContent(String content)
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
