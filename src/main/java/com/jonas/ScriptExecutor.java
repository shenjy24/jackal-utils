package com.jonas;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * <p>
 * js脚本执行工具
 * </p>
 *
 * @author shenjiayun
 * @since 2019-10-28
 */
public class ScriptExecutor {
    private static CalculateDuration duration;
    private static String formulate = "((headShot&&slot==0)||(!headShot&&slot!=0))?max*damage/(-0.000364662607813291*max*max+0.45440131912734527*max+61.66925101471344):0";

    static {
        ScriptEngine engine = new ScriptEngineManager(String.class.getClassLoader()).getEngineByExtension("js");
        try {
            engine.eval("" +
                    "function getCost(max,damage,headShot,slot){return (" + formulate + ")}");
            duration = ((Invocable) engine).getInterface(CalculateDuration.class);
        } catch (ScriptException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public interface CalculateDuration {
        float getCost(int max, float damage, boolean headShot, int slot);
    }

    public static void main(String[] args) {
        float cost = duration.getCost(10, 10, false, 1);
        System.out.println(cost);
    }
}
