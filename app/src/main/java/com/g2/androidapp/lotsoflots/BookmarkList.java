package com.g2.androidapp.lotsoflots;

import java.util.ArrayList;

public class BookmarkList {


    private int numberOfBookmarks;
    private static ArrayList<Bookmark> bookmarkArrayList = new ArrayList<>(0);



    /** Getting the list of bookmarks. */
    public static ArrayList<Bookmark> getBookmark(){return bookmarkArrayList;}



    /** Adding bookmark.*/
    public static void addBookmark(Bookmark bookmark)  {
        bookmarkArrayList.add(bookmark);
    }



    /** deleting bookmark */

    public static void deleteBookmark(Bookmark bookmark){
       bookmarkArrayList.remove(bookmark);
        }

    }







