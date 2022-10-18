import java.util.Objects;

public class Bishop extends Piece {

    public Bishop(int x, int y) {
        super(x, y);
    }

    public Bishop(int x, int y, String color) {
        super(x, y, color);
    }

    @Override
    public String getSymbol() {
        return "B";
    }

    @Override
    public boolean canMove(Board board, int x, int y) {
        int thisX = this.getCoordinatesX();
        int thisY = this.getCoordinatesY();

        if (!board.validate(x, y)) {
            return false;
        }
        if (Math.abs(x - thisX) != Math.abs(y - thisY) || (thisX == x && thisY == y)) {
            return false;
        } else {
            for (Piece piece : board.getPieces()) {
                int thatX = piece.getCoordinatesX();
                int thatY = piece.getCoordinatesY();
                if (Math.abs(thatX - thisX) == Math.abs(thatY - thisY)) {
                    if (x > thisX && y > thisY) {
                        if (thatX > thisX && thatX < x && thatY > thisY && thatY < y) {
                            return false;
                        }
                    } else if (x > thisX && y < thisY) {
                        if (thatX > thisX && thatX < x && thatY > y && thatY < thisY) {
                            return false;
                        }
                    } else if (x < thisX && y > thisY) {
                        if (thatX > x && thatX < thisX && thatY > thisY && thatY < y) {
                            return false;
                        }
                    } else if (x < thisX && y < thisY) {
                        if (thatX > x && thatX < thisX && thatY > y && thatY < thisY) {
                            return false;
                        }
                    }
                }
            }
        }
        return board.getAt(x, y) == null
                || !Objects.equals(board.getAt(x, y).getColor(), this.getColor());
    }
}
