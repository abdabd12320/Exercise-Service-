package com.example.newsarticlemanagementsystem.NewsService;

import com.example.newsarticlemanagementsystem.NewsModel.News;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class NService {

    ArrayList<News> newsArrayList = new ArrayList<>();

    public ArrayList<News> getNewsArrayList() {
        return newsArrayList;
    }

    public void addNew(News news)
    {
        newsArrayList.add(news);
    }

    public boolean updateNew(String id,News news)
    {
        for (int i = 0; i < newsArrayList.size(); i++) {
            if(newsArrayList.get(i).getId().equals(id))
            {
                newsArrayList.set(i,news);
                return true;
            }
        }
        return false;
    }

    public boolean deleteNew(String id)
    {
        for (int i = 0; i < newsArrayList.size(); i++) {
            if(newsArrayList.get(i).getId().equals(id))
            {
                newsArrayList.remove(i);
                return true;
            }
        }
        return false;
    }
    public boolean publishNew(String id)
    {
        for (int i = 0; i < newsArrayList.size(); i++) {
            if(newsArrayList.get(i).getId().equals(id) && !newsArrayList.get(i).isPublished())
            {
                newsArrayList.get(i).setPublished(true);
                return true;
            }
        }
        return false;
    }
    public ArrayList<News> getAllPublishedNews()
    {
        ArrayList<News> newsArrayList1 = new ArrayList<>();
        for (int i = 0; i < newsArrayList.size(); i++) {
            if(newsArrayList.get(i).isPublished())
            {
                newsArrayList1.add(newsArrayList.get(i));
            }
        }
        return newsArrayList1;
    }
    public ArrayList<News> newsArticleByCategory(String category)
    {
        ArrayList<News> newsArrayList1 = new ArrayList<>();
        for (int i = 0; i < newsArrayList.size(); i++) {
            if(newsArrayList.get(i).getCategory().equals(category))
            {
                newsArrayList1.add(newsArrayList.get(i));
            }
        }
        return newsArrayList1;
    }
}
