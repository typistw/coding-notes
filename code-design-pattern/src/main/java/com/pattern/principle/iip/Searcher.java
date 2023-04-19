package com.pattern.principle.iip;

/*
 * @author：jinsheng
 * @date：2023/03/05 16:33
 */
public class Searcher extends AbstractSearcher{

//    public Searcher(IPettyGirl pettyGirl){
//        super(pettyGirl);
//    }


    public Searcher(IGoodBodyGirl goodBodyGirl) {
        super(goodBodyGirl);
    }

    public Searcher(IGreatTemperamentGirl temperamentGirl) {
        super(temperamentGirl);
    }

    @Override
    public void show() {
        System.out.println("-------美女信息如下：-----");
        if(goodBodyGirl != null){
            super.goodBodyGirl.goodLooking();
            super.goodBodyGirl.niceFigure();
        }

        if(temperamentGirl != null){
            super.temperamentGirl.greatTemperament();
        }
    }
}
