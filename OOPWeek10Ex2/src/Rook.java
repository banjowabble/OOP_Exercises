import java.util.Objects;

public class Rook extends Piece {

    public Rook(int x, int y, String color) {
        super(x, y, color);
    }

    public Rook(int x, int y) {
        super(x, y);
    }

    @Override
    public String getSymbol() {
        return "R";
    }

    @Override
    public boolean canMove(Board board, int x, int y) {
        int thisX = this.getCoordinatesX();
        int thisY = this.getCoordinatesY();
        if (!board.validate(x, y)) {
            return false;
        }
        if (x != thisX && y != thisY) {
            return false;
        } else {
            //check for blockades along the road
            if (x == thisX) {
                for (Piece piece : board.getPieces()) {
                    if (piece.getCoordinatesX() == thisX
                            && thisY < piece.getCoordinatesY() && piece.getCoordinatesY() < y) {
                        return false;
                    }
                }
            } else {
                for (Piece piece : board.getPieces()) {
                    if (piece.getCoordinatesY() == thisY
                            && thisX < piece.getCoordinatesX() && piece.getCoordinatesX() < x) {
                        return false;
                    }
                }
            }
            //check for blockades at the destination
            return board.getAt(x, y) == null
                    || !Objects.equals(board.getAt(x, y).getColor(), this.getColor());
        }
    }
}
