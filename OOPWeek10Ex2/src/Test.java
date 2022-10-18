public class Test {
    public static void main(String[] args) {
        Board board = new Board();
        Rook r1 = new Rook(1, 2, "white");
        Rook r2 = new Rook(1, 4, "white");
        Rook r3 = new Rook(3, 4, "black");

        board.addPiece(r1);
        board.addPiece(r2);
        board.addPiece(r3);

        Game game = new Game(board);

        // can't move r1 because r2 block the way
        game.movePiece(r1, 1, 5);
        System.out.println(game.getMoveHistory());

        // can move r1
        game.movePiece(r1, 1 , 3);
        System.out.println(game.getMoveHistory());

        // can move, r2 kill r3
        game.movePiece(r2, 3, 4);
        System.out.println(game.getMoveHistory());
    }
}
