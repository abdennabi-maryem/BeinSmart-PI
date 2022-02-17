/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pijava.NewsCom;

import Entities.News;

/**
 *
 * @author guest
 */
final public class NewsHolder {
    private int idnews;
     private final static NewsHolder INSTANCE = new NewsHolder();
  
  private NewsHolder() {}
 
  
  public static NewsHolder getInstance() {
    return INSTANCE;
  }
  
  public void setNews(int n) {
    this.idnews = n;
  }
  
  public int getNews() {
    return this.idnews;
    
    
}
}
