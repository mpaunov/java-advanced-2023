import java.io.IOException;
import java.sql.SQLDataException;

public class Cow extends Mammal {

    @Override
    public void breath() {
        System.out.println("Breathing like a champ");
    }

    public void goEatGrass() {
        System.out.println("Eating grass.");
    }

}
