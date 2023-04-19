package com.pattern.principle.dip;

/*
 * @author：jinsheng
 * @date：2023/03/05 15:57
 */
public class Driver implements IDriver{

    @Override
    public void driver(ICar car) {
        car.run();
    }
}
