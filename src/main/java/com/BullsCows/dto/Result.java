package com.BullsCows.dto;

/**Tracks the game result of
 *
 */
public class Result {
    private int exact;
    private int partial;

    //constructor
    public Result() {
    }

    //setters
    public void setExact(int exact) {
        this.exact = exact;
    }
    public void setPartial(int partial) {
        this.partial = partial;
    }

    //getters
    public int getExact() {
        return exact;
    }
    public int getPartial() {
        return partial;
    }


    @Override
    public String toString() {
        return "e:" + exact +
                ":p:"+ partial;
    }
}
