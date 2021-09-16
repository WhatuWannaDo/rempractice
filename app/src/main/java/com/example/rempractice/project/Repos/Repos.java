package com.example.rempractice.project.Repos;

import android.app.Application;

import com.example.rempractice.project.Repos.Mock.MDB;
import com.example.rempractice.project.Repos.Room.remRepos;

public class Repos {
    static RepTasks repos;

    static public void init(Application app){
        if(repos == null){
            repos = new remRepos(app);
        }
    }

    static public RepTasks getRepos(){
        if(repos == null){
            repos = new MDB();
        }
        return repos;
    }
}
