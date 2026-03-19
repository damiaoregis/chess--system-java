import java.util.Scanner;

import boardgame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {

    Scanner sc =new Scanner(System.in);
    ChessMatch chessMatch = new ChessMatch();
    while(true){
        UI.printBoard(chessMatch.getPiess());
        IO.println();
        IO.print("Source: ");
        ChessPosition source = UI.readChessPosition(sc);
        IO.println();
        IO.print("Target: ");
        ChessPosition target = UI.readChessPosition(sc);

        ChessPiece capturedPiece =chessMatch.performChessMove(source,target);
    }
    
}
