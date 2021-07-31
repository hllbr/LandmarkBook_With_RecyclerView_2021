package com.hllbr.landmarkbook_with_recyclerview;

public class Singledton {
    private LandMark sentLandmark;
    public static Singledton singledton;
    private Singledton(){

    }
    public LandMark getSentLandmark(){
        return sentLandmark;
    }

    public void setSentLandmark(LandMark sentLandmark) {
        this.sentLandmark = sentLandmark;
    }
    public static  Singledton getInstance(){
        if (singledton == null){
            singledton = new Singledton();
        }

            return singledton;
    }
}
