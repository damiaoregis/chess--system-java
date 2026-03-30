import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {

    Scanner sc = new Scanner(System.in);
    ChessMatch chessMatch = new ChessMatch();
    List<ChessPiece> captured = new ArrayList<>();

    while (!chessMatch.getCheckMate()) {
        try {
            // UI.clearScreen();
            UI.printMatch(chessMatch, captured);
            IO.println();
            IO.print("Source: ");
            ChessPosition source = UI.readChessPosition(sc);
            boolean[][] possibleMoves = chessMatch.possibleMoves(source);
            UI.printBoard(chessMatch.getPieces(), possibleMoves);
            IO.println();
            IO.print("Target: ");
            ChessPosition target = UI.readChessPosition(sc);

            ChessPiece capturedPiece = chessMatch.performChessMove(source, target);

            if (capturedPiece != null) {
                captured.add(capturedPiece); 
            }

            if (chessMatch.getPromoted() != null) {
                IO.print("Enter piece for promotion (B/N/R/Q): ");
                String type = sc.nextLine().toUpperCase();
                while(!type.equals("B") && !type.equals("N") && !type.equals("R") && !type.equals("Q")) {
                    IO.print("Ivalid value! Enter piece for promotion (B/N/R/Q): ");
                    type = sc.nextLine().toUpperCase();
                }

                chessMatch.replacePromoted(type);
            }

        } catch (ChessException | InputMismatchException e) {
            System.out.println(e.getMessage());
            sc.nextLine();
        }

    }UI.printMatch(chessMatch, captured);

}
