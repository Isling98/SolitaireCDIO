package Model;

public class SuitPile extends CardPile {



    boolean isFinished = false;

    public int nextCard(){
        if (!isFinished) {
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


    public void isFinished(){
        isFinished=popCard().getValue() >= 13;
    }







}
