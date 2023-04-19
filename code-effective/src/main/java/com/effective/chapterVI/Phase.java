package com.effective.chapterVI;

import java.util.EnumMap;
import java.util.Map;

/*
 * @author：jinsheng
 * @date：2022/09/17 16:36
 */
public enum  Phase {

    SOLID, LIQUID, GAS
    ;

    public enum Transition{
        MELT(SOLID, LIQUID),
        FREEZE(LIQUID, SOLID),
        BOLD(LIQUID, GAS),
        ;
        private final Phase src;
        private final Phase dst;

        Transition(Phase src, Phase dst){
            this.src = src;
            this.dst = dst;
        }

        private static final Map<Phase, Map<Phase, Transition>> m = new EnumMap<>(Phase.class);

        static {
            for(Phase p : Phase.values()){
                m.put(p, new EnumMap<Phase, Transition>(Phase.class));
            }

            for(Transition t : Transition.values()){
                m.get(t.src).put(t.dst, t);
            }
        }

        public static Transition from(Phase src, Phase dst){
            return m.get(src).get(dst);
        }
    }
}
