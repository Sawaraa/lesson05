package dto;

public class BusketDto {
    public Integer bucketId;
    public String title;
    public String description;
    public String author;
    public int pages;
    public int price;

    @Override
    public String toString() {
        return "BusketDto{" +
                "bucketId=" + bucketId +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", author='" + author + '\'' +
                ", pages=" + pages +
                ", price=" + price +
                '}';
    }
}
