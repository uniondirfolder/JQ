package com.nvv.itstep.hw.d06092021_p2.GoF.behavioral.Strategy.Game;

public class WeaponNoWay implements WeaponBehavior {

    @Override
    public void useWeapon() {
        System.out.println("Character " + this.toString());
    }

    @Override
    public String toString() {
        return "no way weapon";
    }
}
