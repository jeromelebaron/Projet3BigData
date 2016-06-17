package fr.s2re.bigdata.entity;


public class Client {

    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Client(int id) {
        super();
        this.id = id;
    }

    public Client() {
        super();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "Client [id=" + id + "]";
    }

}
