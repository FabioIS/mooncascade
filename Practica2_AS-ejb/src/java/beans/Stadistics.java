/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.ejb.Singleton;
import javax.ejb.LocalBean;

/**
 *
 * @author 1996f
 */
@Singleton
@LocalBean
public class Stadistics {
       
    private int Album;
    private int Bill;
    private int Cart;
    private int CreditCard;
    private int Song;
    private int SongList;
       
    private int BillPage;
    private int FavAlbum;
    private int ListSong;
    private int MyAlbum;
    private int MyCart;
    private int Payment;
    private int Seguro;
    private int index;

    public int getAlbum() {
        return Album;
    }

    public void addAlbum() {
        this.Album++;
    }
    
    
    public int getSongList() {
        return SongList;
    }
    
    public void addSongList(){
        SongList++;
    }
    
    public int getBill() {
        return Bill;
    }

    public void addBill() {
        this.Bill++;
    }

    public int getCart() {
        return Cart;
    }

    public void addCart() {
        this.Cart++;
    }

    public int getCreditCard() {
        return CreditCard;
    }

    public void addCreditCard() {
        this.CreditCard++;
    }

    public int getSong() {
        return Song;
    }

    public void addSong() {
        this.Song++;
    }

    public int getBillPage() {
        return BillPage;
    }

    public void addBillPage() {
        this.BillPage++;
    }

    public int getFavAlbum() {
        return FavAlbum;
    }

    public void addFavAlbum() {
        this.FavAlbum++;
    }

    public int getListSong() {
        return ListSong;
    }

    public void addListSong() {
        this.ListSong++;
    }

    public int getMyAlbum() {
        return MyAlbum;
    }

    public void addMyAlbum() {
        this.MyAlbum++;
    }

    public int getMyCart() {
        return MyCart;
    }

    public void addMyCart() {
        this.MyCart++;
    }

    public int getPayment() {
        return Payment;
    }

    public void addPayment() {
        this.Payment++;
    }

    public int getSeguro() {
        return Seguro;
    }

    public void addSeguro() {
        this.Seguro++;
    }

    public int getIndex() {
        return index;
    }

    public void addIndex() {
        this.index++;
    }
    
   
}
