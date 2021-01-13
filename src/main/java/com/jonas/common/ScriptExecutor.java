package com.jonas.common;

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
    private static final IFormula FORMULA;
    private static final String HEALTH = "health + 25 * con + 20 * str";
    private static final String ATTACK = "(atk + 4 * str + 2.75 * dex) * dmg";

    static {
        String healthFormula = "function getHealth(health, con, str) { return " + HEALTH + "}";
        String attackFormula = "function getAttack(atk, str, dex, dmg) { return " + ATTACK + "}";
        String function = healthFormula + attackFormula;

        ScriptEngine engine = new ScriptEngineManager(String.class.getClassLoader()).getEngineByExtension("js");
        try {
            engine.eval(function);
            FORMULA = ((Invocable) engine).getInterface(IFormula.class);
        } catch (ScriptException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public interface IFormula {
        //获取血量（血量、体质、力量）
        float getHealth(double health, double con, double str);
        //获取攻击（攻击、力量、敏捷、暴击伤害）
        float getAttack(double atk, double str, double dex, double dmg);
    }

    public static void main(String[] args) {
        float health = FORMULA.getHealth(1.0, 1.0, 1.0);
        System.out.println(health);

        float attack = FORMULA.getAttack(1.0, 1.0, 1.0, 1.0);
        System.out.println(attack);
    }
}
