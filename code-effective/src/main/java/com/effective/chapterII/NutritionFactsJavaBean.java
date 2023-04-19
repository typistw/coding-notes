package com.effective.chapterII;

import lombok.Data;

/*
 * JavaBean模式（线程安全问题）
 * @author：jinsheng
 * @date：2022/08/09 00:23
 */
@Data
public class NutritionFactsJavaBean {
    private int servingSize  = -1;
    private int servings= -1;
    private int calories = 0;
    private int fat = 0;
    private int sodium = 0;
    private int carbohydrate = 0;

    public NutritionFactsJavaBean(){}
}
