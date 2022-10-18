import java.util.ArrayList;

public class Game {
    private Board board;
    private ArrayList<Move> moveHistory;

    Game(Board board) {
        this.board = board;
        moveHistory = new ArrayList<>();
    }

    /**
     * move a piece.
     */
    public void movePiece(Piece piece, int x, int y) {
        if (piece.canMove(board, x, y)) {
            if (board.getAt(x, y) != null) {
                Move move = new Move(piece.getCoordinatesX(), piece.getCoordinatesY(),
                        x, y, piece, board.getAt(x, y));
                moveHistory.add(move);
                board.removeAt(x, y);
            } else {
                Move move = new Move(piece.getCoordinatesX(), piece.getCoordinatesY(),
                        x, y, piece);
                moveHistory.add(move);
            }
            piece.setCoordinatesX(x);
            piece.setCoordinatesY(y);
        }
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public ArrayList<Move> getMoveHistory() {
        return moveHistory;
    }
}
