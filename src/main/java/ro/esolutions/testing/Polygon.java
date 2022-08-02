package ro.esolutions.testing;


import lombok.Data;

@Data
public class Polygon {

    private Integer numberOfSides;

    public Polygon(Integer numberOfSides) {
        if (numberOfSides <= 2) {
            throw new RuntimeException("you need to have more than 2 side for a polygon");
        }
        this.numberOfSides = numberOfSides;
    }

}
