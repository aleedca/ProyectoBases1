/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objects;

/**
 *
 * @author Nahomy
 */
public class MostViewedNews {
    private String title;
    private int views;

    public MostViewedNews() {
    }

    public MostViewedNews(String title, int views) {
        this.title = title;
        this.views = views;
    }
    
    

    public String getTitle() {
        return title;
    }

    public int getViews() {
        return views;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setViews(int views) {
        this.views = views;
    }

    @Override
    public String toString() {
        return "MostViewedNews{" + "title=" + title + ", views=" + views + '}';
    }

    public MostViewedNews get(int i) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
