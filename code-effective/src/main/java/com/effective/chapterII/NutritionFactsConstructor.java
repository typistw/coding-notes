package com.effective.chapterII;

/*
 *  重叠构造器模式 (可读性差)
 * @author：jinsheng
 * @date：2022/08/09 00:23
 */
public class NutritionFactsConstructor {
    private int servingSize  = -1;
    private int servings= -1;
    private int calories = 0;
    private int fat = 0;
    private int sodium = 0;
    private int carbohydrate = 0;

    public NutritionFactsConstructor(int servingSize, int servings){
        this(servingSize, servings, 0);
    }

    public NutritionFactsConstructor(int servingSize, int servings, int calories){

        this(servingSize, servings, calories,0);
    }

    public NutritionFactsConstructor(int servingSize, int servings, int calories, int fat){

        this(servingSize, servings, calories,fat,0);
    }

    public NutritionFactsConstructor(int servingSize, int servings, int calories, int fat,
                                     int sodium){
        this(servingSize, servings, calories,fat,sodium,0);
    }

    public NutritionFactsConstructor(int servingSize, int servings, int calories, int fat,
                                     int sodium, int carbohydrate){
        this.servingSize = servingSize;
        this.servings = servings;
        this.calories = calories;
        this.fat = fat;
        this.sodium = sodium;
        this.carbohydrate = carbohydrate;
    }
}
