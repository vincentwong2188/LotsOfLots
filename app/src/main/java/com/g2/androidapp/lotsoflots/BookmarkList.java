package com.g2.androidapp.lotsoflots;

import java.util.ArrayList;

public class BookmarkList {

    private int numberOfBookmarks;
    private ArrayList<Bookmark> bookmarkArrayList = new ArrayList<>(0);



    /** Getting the list of bookmarks. */
    public ArrayList<Bookmark> getBookmark(){return bookmarkArrayList;}



    /** Adding bookmark.*/
    public void addBookmark(double _long, double _lat)  {
        bookmarkArrayList.add(new Bookmark(_long, _lat));
    }



    /** deleting bookmark */

    public void deleteBookmark(double _long, double _lat){
        Bookmark deleting = new Bookmark (_long, _lat);

        for(int j = 0; j < bookmarkArrayList.size(); j++)
        {

            if(deleting == bookmarkArrayList.get(j)) {
                //found, delete.
                bookmarkArrayList.remove(j);
            }
            break;

        }

    }
}






