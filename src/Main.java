import java.util.InputMismatchException;
import java.util.Scanner;

import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPosition;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {

    Scanner sc = new Scanner(System.in);
    ChessMatch chessMatch = new ChessMatch();
    while(true){
        try {
           // UI.clearScreen();
            UI.printBoard(chessMatch.getPiess());
            IO.println();
            IO.print("Source: ");
            ChessPosition source = UI.readChessPosition(sc);
            IO.println();
            IO.print("Target: ");
            ChessPosition target = UI.readChessPosition(sc);
            chessMatch.performChessMove(source, target);

        } catch (ChessException | InputMismatchException e) {
            System.out.println(e.getMessage());
            sc.nextLine();
        }

    }
    
}
