package tedu.store.entity;

public class CollectionDao {


    private Integer id;
    private Integer oid;
    private Integer uid;
    private String image;
    private Integer price;
    private String title;

    public CollectionDao() {

    }


    public CollectionDao(Integer id, Integer oid, Integer uid, String image, Integer price, String title) {
        this.id = id;
        this.oid = oid;
        this.uid = uid;
        this.image = image;
        this.price = price;
        this.title = title;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "CollectionDao{" +
                "id=" + id +
                ", oid=" + oid +
                ", uid=" + uid +
                ", image='" + image + '\'' +
                ", price=" + price +
                ", title='" + title + '\'' +
                '}';
    }
}
