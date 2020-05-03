package com.fhlxc.help;

/**
* @author Xingchao Long
* @date 2020年5月1日 下午2:10:33
* @classname Calculate
* @description 
*/

public class Calculate {
    
    //计算所对应的税率和速算扣除数
    private static float[] num(float t) {
        float cal = 0;
        float c = 0;
        if (t <= 36000) {
            cal = 0.03f;
            c = 0;
        }
        if (t > 36000 && t <= 144000) {
            cal = 0.1f;
            c = 210;
        }
        if (t > 144000 && t <= 300000) {
            cal = 0.2f;
            c = 1410;
        }
        if (t > 300000 && t <= 420000) {
            cal = 0.25f;
            c = 2660;
        }
        if (t > 420000 && t <= 660000) {
            cal = 0.3f;
            c = 4410;
        }
        float[] xxx = new float[2];
        xxx[0] = cal;
        xxx[1] = c;
        return xxx;
          
    }

    public static void main(String[] args) {
        //x为总的工资，扣除不交税的60000
        float x = 490124.24f - 60000;
        //xx为年终奖学金，初始1万
        int xx = 10000;
        //缴纳的税
        float sum = Float.MAX_VALUE;
        //两个中间结果
        float result1;
        float result2;
        //最优的年终奖
        float n = 0;
        //税率和速算扣除数
        float[] xxx = new float[2];
        for (; xx < 430000; xx++) {
            xxx = num(xx);
            //计算年终奖的税收
            result1 = xxx[0] * xx - xxx[1];
            xxx = num(x - xx);
            //计算工资的税收
            result2 = xxx[0] * (x - xx) - xxx[1] * 12;
            //取最小值，最优值
            if (sum > result1 + result2) {
                sum = result1 + result2;
                n = xx;
            }
        }
        result1 = x - n;
        System.out.println("最优年工资" + result1 + "最优年终奖：" + n + ";最少税收：" + sum);
    }

}
