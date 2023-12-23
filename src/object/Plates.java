package object;

public class Plates extends ImageObject {

    private String color;
    private MovingBehaviour move;
    private Hand hand = null;

    public Plates(int x, int y, String path, String color) {
        super(x, y, path);
        this.color = color;
        //starting moving behaviour before landing on the character's hands
        move = new ObjectBeforeIntersection();

    }

    public String getColor() {
        return this.color;
    }

    public void setMovingBehaviour(MovingBehaviour move) {
        this.move = move;
    }

    public void setHand(Hand h) {
        this.hand = h;
    }

    @Override
    public void setY(int y) {

        if (move instanceof ObjectBeforeIntersection) {
            super.setY(y);
        } else {
            //after joining the character movement
            // do nothing
        }
    }

    @Override
    public void setX(int x) {
        if (hand == Hand.Right) {
            if (x <= 191 - getWidth()) {
                //do nothing
            } else {
                super.setX(x);
            }
        } else if (hand == Hand.Left) {
            if (x >= 900 - 191) {
                //do nothing
            } else {
                super.setX(x);
            }
        } else {
            super.setX(x);
        }
    }
}
