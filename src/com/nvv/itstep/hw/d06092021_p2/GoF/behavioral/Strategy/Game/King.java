package com.nvv.itstep.hw.d06092021_p2.GoF.behavioral.Strategy.Game;

public class King extends Character {
    public King() {
        weaponBehavior = new WeaponNoWay();
    }

    public King(String name) {
        this.name = name;
        weaponBehavior = new WeaponNoWay();
    }

    public King(String name, WeaponBehavior weaponBehavior) {
        this.name = name;
        this.weaponBehavior = weaponBehavior;
    }

    @Override
    public void fight() {
        if(weaponBehavior instanceof WeaponNoWay) {
            System.out.println(name + " not fighting");
        } else System.out.println(name + " good fighting with " + weaponBehavior);
    }
}