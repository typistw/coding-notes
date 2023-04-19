package com.pattern.factory;

/*
 * @author：jinsheng
 * @date：2023/04/09 15:55
 */
public  abstract  class AbstractHumanFactory {
    public abstract <T extends Human> T createHuman(Class<T> c);
}
