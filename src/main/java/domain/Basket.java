package domain;

public class Basket {

    private int idBasket;
    private int idUser;
    private int idProduct;

    public Basket(int idBasket, int idUser, int idProduct) {
        this.idBasket = idBasket;
        this.idUser = idUser;
        this.idProduct = idProduct;
    }

    public Basket(int idUser, int idProduct) {
        this.idUser = idUser;
        this.idProduct = idProduct;
    }

    public int getIdBasket() {
        return idBasket;
    }

    public void setIdBasket(int idBasket) {
        this.idBasket = idBasket;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    @Override
    public String toString() {
        return "Basket{" +
                "idBasket=" + idBasket +
                ", idUser=" + idUser +
                ", idProduct=" + idProduct +
                '}';
    }
}
