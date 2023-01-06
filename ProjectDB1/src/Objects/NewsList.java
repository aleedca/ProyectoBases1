/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objects;

/**
 *
 * @author Nahomy
 */
public class NewsList {
    
    String author;
    String authorLastName;
    String title;
    String newsDate;
    String typeNews; 

    public NewsList() {
    }

    public NewsList(String author, String authorLastName, String title, String newsDate, String typeNews) {
        this.author = author;
        this.authorLastName = authorLastName;
        this.title = title;
        this.newsDate = newsDate;
        this.typeNews = typeNews;
    }
    
    //setters
    public void setAuthor(String author) {
        this.author = author;
    }

    public void setAuthorLastName(String authorLastName) {
        this.authorLastName = authorLastName;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setNewsDate(String newsDate) {
        this.newsDate = newsDate;
    }

    public void setTypeNews(String typeNews) {
        this.typeNews = typeNews;
    }
    
    //getters
    public String getAuthor() {
        return author;
    }

    public String getAuthorLastName() {
        return authorLastName;
    }

    public String getTitle() {
        return title;
    }

    public String getNewsDate() {
        return newsDate;
    }

    public String getTypeNews() {
        return typeNews;
    }

    

    @Override
    public String toString() {
        return "NewsList{" + "author=" + author + ", authorLastName=" + authorLastName + ", title=" + title + ", newsDate=" + newsDate + ", typeNews=" + typeNews + '}';
    }

   


}

    