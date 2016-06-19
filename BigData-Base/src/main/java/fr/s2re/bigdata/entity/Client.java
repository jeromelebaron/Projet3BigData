package fr.s2re.bigdata.entity;

public class Client {

    private int id;

    public Client() {
        super();
    }

    public Client(int id) {
        super();
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "Client [id=" + id + "]";
    }

}
