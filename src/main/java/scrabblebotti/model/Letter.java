
package scrabblebotti;

public class Letter {
    String letter;
    Letter[] next;
    boolean last;

    public Letter(String letter, boolean last) {
        this.letter = letter;
        this.next = new Letter[250];
        this.last = last;
    }

    public String getLetter() {
        return letter;
    }

    public Letter[] getNext() {
        return next;
    }

    public boolean isLast() {
        return last;
    }
    
    public void setLetter(String letter) {
        this.letter = letter;
    }

    public void setNext(Letter[] next) {
        this.next = next;
    }

    public void setLast(boolean last) {
        this.last = last;
    }
    

}

