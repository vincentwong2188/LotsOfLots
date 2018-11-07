package com.g2.androidapp.lotsoflots;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class BookmarkList {

    private int numberOfBookmarks;
    private ArrayList<Bookmark> bookmarkArrayList = new ArrayList<>(0);



    /** Getting the list of bookmarks. */
    public ArrayList<Bookmark> getBookmark() {
        return bookmarkArrayList;
    }


    /** Adding bookmark.
     * SHOULD AN ARRAY LIST OF BOOKMARKS BE RETURNED? */
    public void /* ArrayList<Bookmark>*/ addBookmark(String location){
        bookmarkArrayList.add(new Bookmark(location));
        /*return bookmarkArrayList;*/

    }


    /** deleting bookmark */


    public ArrayList<Bookmark> deleteBookmark(String Location){
        for(int j = 0; j < bookmarkArrayList.size(); j++)
        {
            Bookmark deleting = bookmarkArrayList.get(j);

            if(deleting.equals(deleteBookmark(Location)))
                //found, delete.
                bookmarkArrayList.remove(j);
                break;
            }
            return bookmarkArrayList;

        }
    }




















/*  public Bookmark getBookmark(String location) {
for(int j = 0; j < bookmarkArrayList.size(); j++)
if ( bookmarkArrayList.get(j) =

        return  ArrayList<Bookmark>.get(j)
    }

*/






