package com.BullsCows.ui;

public class BullsCowsView {

    /**Declaration of the UserIO*/
    private UserIO io;

    /**
     * Prints the Main menu's options on console,
     * then returns an int of the user's choice
     * @return - an int of the user's choice
     */
    public int printMainMenu(){
        io.print("");
        io.print("-+*+-+*+-+*+-+*+-+*+-+*+-+*+-+*+-+*+-+*+-+*+-+*+-");
        io.print("<<Bulls and Cows>>");
        io.print("1. Starts a game");
        io.print("2. Make a guess");
        io.print("3. Return list of all games");
        io.print("4. Return specific game");
        io.print("5. Return list of rounds");
        io.print("6. Quit");
        io.print("");
        io.print("-+*+-+*+-+*+-+*+-+*+-+*+-+*+-+*+-+*+-+*+-+*+-+*+-");

        return io.readInt("", 1, 6);

    }


}
