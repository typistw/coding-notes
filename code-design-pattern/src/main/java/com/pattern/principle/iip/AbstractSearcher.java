package com.pattern.principle.iip;

public abstract class AbstractSearcher {

//    protected IPettyGirl pettyGirl;

//    public AbstractSearcher(IPettyGirl pettyGirl){
//        this.pettyGirl = pettyGirl;
//    }


    protected IGoodBodyGirl goodBodyGirl;
    protected IGreatTemperamentGirl temperamentGirl;

    public AbstractSearcher(IGoodBodyGirl goodBodyGirl) {
        this.goodBodyGirl = goodBodyGirl;
    }

    public AbstractSearcher(IGreatTemperamentGirl temperamentGirl){
        this.temperamentGirl = temperamentGirl;
    }

    /**
     * 搜索美女，列出美女信息
     */
    public abstract void show();
}
