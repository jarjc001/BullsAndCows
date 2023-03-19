package com.BullsCows.dto;

import java.util.Objects;

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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Result result = (Result) o;
        return exact == result.exact && partial == result.partial;
    }

    @Override
    public int hashCode() {
        return Objects.hash(exact, partial);
    }
}
