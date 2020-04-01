package Game.Model;

import java.util.LinkedList;

public class SuitPile extends CardPile {

    public int nextCard(){
        if (!isFinished()) {
            if (super.isEmpty()){
                return 1;
            }
            else {
                return super.popCard().getValue() + 1;
            }
        }
        // Returnerer 0 hvis rækken er fuldført
        else return 0;
    }


    public boolean isFinished(){
        if (super.popCard().getValue() == 13){
            return true;
        }
        else {
            return false;
        }
    }







}
