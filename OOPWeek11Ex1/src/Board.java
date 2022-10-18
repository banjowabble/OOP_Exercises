import java.util.ArrayList;

public class Board {
    public static final int WIDTH = 8;
    public static final int HEIGHT = 8;
    private ArrayList<Piece> pieces;

    public Board() {
        pieces = new ArrayList<>();
    }

    public boolean validate(int x, int y) {
        return x >= 1 && x <= 8 && y >= 1 && y <= 8;
    }

    /**
     * add a new piece on the board.
     */
    public void addPiece(Piece piece) {
        int x = piece.getCoordinatesX();
        int y = piece.getCoordinatesY();
        if (validate(x, y) && !pieces.contains(piece)) {
            pieces.add(piece);
        }
    }

    /**
     * access a piece on the board.
     */
    public Piece getAt(int x, int y) {
        for (Piece piece : pieces) {
            if (piece.getCoordinatesX() == x
                    && piece.getCoordinatesY() == y) {
                return piece;
            }
        }
        return null;
    }

    public void removeAt(int x, int y) {
        pieces.removeIf(piece -> piece.getCoordinatesX() == x
                && piece.getCoordinatesY() == y);
    }

    public ArrayList<Piece> getPieces() {
        return pieces;
    }

    public void setPieces(ArrayList<Piece> pieces) {
        this.pieces = pieces;
    }
}
