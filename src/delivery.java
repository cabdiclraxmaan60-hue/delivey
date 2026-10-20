import java.util.ArrayList;
import java.util.Scanner;

abstract class Delivery {
    protected int distance;
    protected int weight;

    public Delivery() {
        this.distance = 0;
        this.weight = 0;
    }

    public Delivery(int distance, int weight) {
        this();
        this.distance = distance;
        this.weight = weight;
    }

    public abstract long calculateFee();
}

class RegularDelivery extends Delivery {
    public RegularDelivery(int distance, int weight) {
        super(distance, weight);
    }

    @Override
    public long calculateFee() {
        return 10L + (2L * distance) + weight;
    }
}

class ExpressDelivery extends Delivery {
    public ExpressDelivery(int distance, int weight) {
        super(distance, weight);
    }

    @Override
    public long calculateFee() {
        return 25L + (4L * distance) + (2L * weight);
    }
}