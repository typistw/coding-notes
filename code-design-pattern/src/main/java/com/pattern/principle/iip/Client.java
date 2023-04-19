package com.pattern.principle.iip;

/*
 * @author：jinsheng
 * @date：2023/03/05 16:35
 */
public class Client {

    public static void main(String[] args) {
        IGoodBodyGirl yanYan = new PettyGirl("渊渊");
        AbstractSearcher searcher = new Searcher(yanYan);

        searcher.show();
    }
}
