package domain;

import javax.persistence.*;

@Entity
@Table(name = "basket")
public class Basket {

    @Id
    @GeneratedValue
    private String idBasket;

    @ManyToOne
    @JoinColumn(name = "idUser  ", referencedColumnName = "idUser")
    private User user;

    @ManyToOne
    @JoinColumn(name = "idProduct", referencedColumnName = "idProduct")
    private Product product;

    public Basket(){

    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    //    public Basket(int idBasket, int idUser, int idProduct) {
//        this.idBasket = idBasket;
//        this.idUser = idUser;
//        this.idProduct = idProduct;
//    }
//
//    public Basket(int idUser, int idProduct) {
//        this.idUser = idUser;
//        this.idProduct = idProduct;
//    }

    public String getIdBasket() {
        return idBasket;
    }

    public void setIdBasket(String idBasket) {
        this.idBasket = idBasket;
    }

//    public int getIdUser() {
//        return idUser;
//    }
//
//    public void setIdUser(int idUser) {
//        this.idUser = idUser;
//    }
//
//    public int getIdProduct() {
//        return idProduct;
//    }
//
//    public void setIdProduct(int idProduct) {
//        this.idProduct = idProduct;
//    }


    @Override
    public String toString() {
        return "Basket{" +
                "idBasket=" + idBasket +
                ", user=" + user.getIdUser() +
                ", product=" + product.getId() +
                '}';
    }
}
