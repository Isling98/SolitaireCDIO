package Model.Gamemodel;

public class SuitPile extends CardPile {





    public int nextCard(){
        if (!isFinished()) {
            if (isEmpty()){
                return 1;
            }
            else {
                return popCard().getValue() + 1;
            }
        }
        // Returnerer 0 hvis rækken er fuldført
        else return 0;
    }


    public boolean isFinished(){
        if (popCard().getValue() >= 13){
            return true;
        }
        else {
            return false;
        }
    }







}
