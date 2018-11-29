/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.BookstoreData;

import Business.BookstoreData.Book;
import java.util.ArrayList;

/**
 *
 * @author Ami Gandhi
 */


public class BookDirectory {
    private ArrayList<Book> BookList = new  ArrayList<>();

    public BookDirectory(ArrayList<Book> BookList) {
        this.BookList = BookList;
    }

    public ArrayList<Book> getBookList() {
        return BookList;
    }

    public void setBookList(ArrayList<Book> BookList) {
        this.BookList = BookList;
    }
    
    public void addBooks(String bookName, double bookPrice, String bookAuthor, String booktype, int noOfBooks)
    {
        Book book = new Book();
        book.setBookName(bookName);
        book.setBookPrice(bookPrice);
        book.setBookAuthor(bookAuthor);
        book.setBooktype(booktype);
        book.setNoOfBooks(noOfBooks);
        BookList.add(book);
    }
}
